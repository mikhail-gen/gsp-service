package com.example.gsp.mapper;

import com.example.gsp.dto.user.CreateUserRequestDto;
import com.example.gsp.dto.user.CreateUserResponseDto;
import com.example.gsp.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(CreateUserRequestDto dto);

    CreateUserResponseDto toResponseDto(User user);
}