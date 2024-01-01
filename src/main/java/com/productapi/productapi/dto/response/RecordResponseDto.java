package com.productapi.productapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecordResponseDto {
    private Long id;
    private LocalDate entryDate;
    private int itemCode;
    private String itemName;
    private int itemQuantity;
    private String status;
}
