package com.productapi.productapi.service;

import com.productapi.productapi.dto.request.RecordRequestDto;
import com.productapi.productapi.dto.response.RecordResponseDto;

import java.util.List;

public interface RecordService {
    void save(List<RecordRequestDto> records);
    List<RecordResponseDto> getAll();
}
