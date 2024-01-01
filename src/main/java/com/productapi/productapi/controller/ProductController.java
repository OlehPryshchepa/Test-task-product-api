package com.productapi.productapi.controller;

import com.productapi.productapi.dto.request.RecordRequestWrapperDto;
import com.productapi.productapi.dto.response.RecordResponseWrapperDto;
import com.productapi.productapi.service.RecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Tag(name = "Products controller", description = "Endpoints for managing products")
public class ProductController {
    private final RecordService recordService;

    @GetMapping("/all")
    @Operation(summary = "Get all Products", description = "Endpoint to retrieve all products.")
    public ResponseEntity<RecordResponseWrapperDto> getAll() {
        return ResponseEntity.ok(new RecordResponseWrapperDto(recordService.getAll()));
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create Product", description = "Endpoint to create a new product.")
    public void create(@RequestBody @Valid RecordRequestWrapperDto recordWrapper) {
        recordService.save(recordWrapper.getRecords());
    }
}
