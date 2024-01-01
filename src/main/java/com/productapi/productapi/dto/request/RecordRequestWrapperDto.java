package com.productapi.productapi.dto.request;

import jakarta.validation.Valid;
import lombok.Data;
import java.util.List;

@Data
public class RecordRequestWrapperDto {
    @Valid
    private List<RecordRequestDto> records;
}
