package com.productapi.productapi.service;

import com.productapi.productapi.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    User findByUsername(String name);
    void save(User user);
    UserDetailsService userDetailsService();
}
