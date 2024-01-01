package com.productapi.productapi.controller;

import com.productapi.productapi.dto.response.ApiExceptionResponse;
import com.productapi.productapi.exception.InvalidUserNameOrPasswordException;
import com.productapi.productapi.exception.UserAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomGlobalExceptionHandler {

    @ExceptionHandler(value = UserAlreadyExistException.class)
    public ResponseEntity<ApiExceptionResponse> handleUserAlreadyExistException(UserAlreadyExistException ex) {
        ApiExceptionResponse exception = ApiExceptionResponse.builder()
                .status(HttpStatus.CONFLICT.value())
                .message(ex.getMessage())
                .date(new Date())
                .build();
        return new ResponseEntity<>(exception, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = InvalidUserNameOrPasswordException.class)
    public ResponseEntity<ApiExceptionResponse> handleInvalidUserNameOrPasswordException(InvalidUserNameOrPasswordException ex) {
        ApiExceptionResponse exception = ApiExceptionResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .date(new Date())
                .build();
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
