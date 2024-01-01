package com.productapi.productapi.mapper;

import com.productapi.productapi.dto.request.UserRequestDto;
import com.productapi.productapi.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User mapToEntity(UserRequestDto adminRegistrationDto);
}
