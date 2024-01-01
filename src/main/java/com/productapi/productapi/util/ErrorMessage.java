package com.productapi.productapi.util;

public class ErrorMessage {
    public static final String EMPTY_USERNAME_ERROR_MESSAGE = "Username can`t be empty";
    public static final String EMPTY_PASSWORD_ERROR_MESSAGE = "Password can`t be empty";
    public static final String EMPTY_ITEM_NAME_ERROR_MESSAGE = "Item name can`t be empty";
    public static final String EMPTY_STATUS_ERROR_MESSAGE = "Status can`t be empty";
    public static final String USERNAME_SIZE_ERROR_MESSAGE = "Size must be between 4 and 16";
    public static final String PASSWORD_SIZE_ERROR_MESSAGE = "Size must be between 8 and 16";
    public static final String PASSWORD_VALIDATION_ERROR_MESSAGE = "Password must be match with pattern: \"^(?=.*[a-zA-Z])(?=.*\\\\d).{8,16}$\"";
    public static final String ENTRY_DATE_FORMAT_ERROR_MESSAGE = "Date must be in the format 'dd-MM-yyyy'";
    public static final String ITEM_CODE_ERROR_MESSAGE = "Must be positive and bigger than zero";
    public static final String ITEM_QUANTITY_ERROR_MESSAGE = "Must be positive and bigger than zero";
}
