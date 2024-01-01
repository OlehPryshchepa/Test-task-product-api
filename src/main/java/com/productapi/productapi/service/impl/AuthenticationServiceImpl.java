package com.productapi.productapi.service.impl;

import com.productapi.productapi.exception.InvalidUserNameOrPasswordException;
import com.productapi.productapi.exception.UserAlreadyExistException;
import com.productapi.productapi.model.Role;
import com.productapi.productapi.model.User;
import com.productapi.productapi.dto.request.UserRequestDto;
import com.productapi.productapi.dto.response.JwtResponse;
import com.productapi.productapi.mapper.UserMapper;
import com.productapi.productapi.repository.UserRepository;
import com.productapi.productapi.service.AuthenticationService;
import com.productapi.productapi.service.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;

    @Override
    public JwtResponse signup(UserRequestDto request) {
        User user = userMapper.mapToEntity(request);
        if ( userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new UserAlreadyExistException("User with username: '" + user.getUsername() + "' already exist");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        userRepository.save(user);
        String token = jwtService.generateToken(user);
        return new JwtResponse(token);
    }

    @Override
    public JwtResponse signin(UserRequestDto request) {
        User user = userMapper.mapToEntity(request);

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        } catch (AuthenticationException e) {
            throw new InvalidUserNameOrPasswordException("Invalid username or password");
        }

        String token = jwtService.generateToken(user);
        return new JwtResponse(token);
    }
}
