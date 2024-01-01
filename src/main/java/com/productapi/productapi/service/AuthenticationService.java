package com.productapi.productapi.service;

import com.productapi.productapi.dto.request.UserRequestDto;
import com.productapi.productapi.dto.response.JwtResponse;

public interface AuthenticationService {
    JwtResponse signup(UserRequestDto request);

    JwtResponse signin(UserRequestDto request);
}
