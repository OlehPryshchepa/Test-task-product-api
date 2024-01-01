package com.productapi.productapi.mapper;

import com.productapi.productapi.dto.request.RecordRequestDto;
import com.productapi.productapi.dto.response.RecordResponseDto;
import com.productapi.productapi.model.Record;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RecordMapper {
    RecordResponseDto mapToDto(Record record);

    @Mapping(source = "entryDate", target = "entryDate", dateFormat = "MM-dd-yyyy")
    Record mapToEntity(RecordRequestDto adminRegistrationDto);
}
