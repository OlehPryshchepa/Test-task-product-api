package com.productapi.productapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.productapi.productapi.dto.request.RecordRequestDto;
import com.productapi.productapi.dto.request.RecordRequestWrapperDto;
import com.productapi.productapi.dto.request.UserRequestDto;
import com.productapi.productapi.dto.response.JwtResponse;
import com.productapi.productapi.dto.response.RecordResponseDto;
import com.productapi.productapi.dto.response.RecordResponseWrapperDto;
import com.productapi.productapi.service.AuthenticationService;
import com.productapi.productapi.service.RecordService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AuthenticationControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private RecordService recordService;

    @Test
    public void endToEnd() throws Exception {
        UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.setUsername("testuser");
        userRequestDto.setPassword("Abcd1234");

        // Signup
        mockMvc.perform(post("/users/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userRequestDto)))
                .andExpect(status().isOk());

        // Signin
        MvcResult signinResult = mockMvc.perform(post("/users/authenticate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userRequestDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token", notNullValue()))
                .andReturn();

        // Extract token from signin response
        JwtResponse jwtResponse = objectMapper.readValue(signinResult.getResponse().getContentAsString(), JwtResponse.class);
        String token = jwtResponse.getToken();

        // Create product
        RecordRequestDto recordRequestDto = new RecordRequestDto("03-01-2023", 1, "TestProduct", 10, "ACTIVE");
        RecordRequestWrapperDto recordWrapperDto = new RecordRequestWrapperDto();
        recordWrapperDto.setRecords(List.of(recordRequestDto));

        mockMvc.perform(post("/products/add")
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(recordWrapperDto)))
                .andExpect(status().isCreated());

        // Get all products
        MvcResult getAllResult = mockMvc.perform(get("/products/all")
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andReturn();

        // Verify product retrieval
        RecordResponseWrapperDto recordResponseWrapperDto = objectMapper.readValue(getAllResult.getResponse().getContentAsString(), RecordResponseWrapperDto.class);
        List<RecordResponseDto> retrievedRecords = recordResponseWrapperDto.getSavedRecords();

        assertThat(retrievedRecords, hasSize(1));
        assertThat(retrievedRecords.get(0).getItemName(), is("TestProduct"));
    }
}
