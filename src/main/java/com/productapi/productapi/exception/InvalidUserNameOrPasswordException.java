package com.productapi.productapi.exception;

public class InvalidUserNameOrPasswordException extends RuntimeException{
    public InvalidUserNameOrPasswordException(String message) {
        super(message);
    }
}
