package com.productapi.productapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordResponseWrapperDto {
    private List<RecordResponseDto> savedRecords;
}
