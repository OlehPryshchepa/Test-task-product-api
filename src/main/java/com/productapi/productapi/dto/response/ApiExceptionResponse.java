package com.productapi.productapi.dto.response;

import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class ApiExceptionResponse {
    private int status;
    private String message;
    private Date date;
}
