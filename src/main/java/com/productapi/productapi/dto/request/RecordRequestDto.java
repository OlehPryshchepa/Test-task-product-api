package com.productapi.productapi.dto.request;

import com.productapi.productapi.util.Constants;
import com.productapi.productapi.util.ErrorMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecordRequestDto {
    @Pattern(regexp = Constants.DATE_TIME_REGEX, message = ErrorMessage.ENTRY_DATE_FORMAT_ERROR_MESSAGE)
    private String entryDate;
    @Positive(message = ErrorMessage.ITEM_CODE_ERROR_MESSAGE)
    private int itemCode;
    @NotBlank(message = ErrorMessage.EMPTY_ITEM_NAME_ERROR_MESSAGE)
    private String itemName;
    @Positive(message = ErrorMessage.ITEM_QUANTITY_ERROR_MESSAGE)
    private int itemQuantity;
    @NotBlank(message = ErrorMessage.EMPTY_STATUS_ERROR_MESSAGE)
    private String status;
}
