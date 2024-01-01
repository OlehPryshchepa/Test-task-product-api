package com.productapi.productapi.service.impl;

import com.productapi.productapi.dto.request.RecordRequestDto;
import com.productapi.productapi.dto.response.RecordResponseDto;
import com.productapi.productapi.mapper.RecordMapper;
import com.productapi.productapi.repository.RecordRepository;
import com.productapi.productapi.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordServiceImpl implements RecordService {
    private final RecordRepository recordRepository;
    private final RecordMapper recordMapper;

    @Override
    public void save(List<RecordRequestDto> records) {
        recordRepository.saveAll(records.stream()
                .map(recordMapper::mapToEntity)
                .toList());
    }

    @Override
    public List<RecordResponseDto> getAll() {
        return recordRepository.getAll().stream()
                .map(recordMapper::mapToDto)
                .toList();
    }
}
