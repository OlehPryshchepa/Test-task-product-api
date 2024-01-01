package com.productapi.productapi.dto.request;

import com.productapi.productapi.annotation.Password;
import com.productapi.productapi.util.Constants;
import com.productapi.productapi.util.ErrorMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequestDto {
    @NotBlank(message = ErrorMessage.EMPTY_USERNAME_ERROR_MESSAGE)
    @Size(min = Constants.USERNAME_MIN_SIZE,
            max = Constants.USERNAME_MAX_SIZE,
            message = ErrorMessage.USERNAME_SIZE_ERROR_MESSAGE)
    private String username;

    @Password(message = ErrorMessage.PASSWORD_VALIDATION_ERROR_MESSAGE)
    @NotBlank(message = ErrorMessage.EMPTY_PASSWORD_ERROR_MESSAGE)
    @Size(min = Constants.PASSWORD_MIN_SIZE,
            max = Constants.PASSWORD_MAX_SIZE,
            message = ErrorMessage.PASSWORD_SIZE_ERROR_MESSAGE)
    private String password;
}
