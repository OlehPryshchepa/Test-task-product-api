package com.productapi.productapi.controller;

import com.productapi.productapi.dto.request.UserRequestDto;
import com.productapi.productapi.dto.response.JwtResponse;
import com.productapi.productapi.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Tag(name = "Authentication controller", description = "Endpoints for user authentication and creation new")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/add")
    @Operation(summary = "User Signup", description = "Endpoint to register a new user.")
    public ResponseEntity<JwtResponse> signup(@RequestBody @Valid UserRequestDto request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/authenticate")
    @Operation(summary = "User Signin", description = "Endpoint to authenticate and generate JWT token.")
    public ResponseEntity<JwtResponse> signin(@RequestBody @Valid UserRequestDto request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}
