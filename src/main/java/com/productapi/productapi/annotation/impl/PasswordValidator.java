package com.productapi.productapi.annotation.impl;

import com.productapi.productapi.annotation.Password;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<Password, String> {
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d).{8,16}$");

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        return password != null && PASSWORD_PATTERN.matcher(password).matches();
    }
}
