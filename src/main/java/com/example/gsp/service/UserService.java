package com.example.gsp.service;

import com.example.gsp.dto.user.CreateUserRequestDto;
import com.example.gsp.dto.user.CreateUserResponseDto;

import java.util.List;

public interface UserService {

    CreateUserResponseDto createUser(CreateUserRequestDto request);

    List<CreateUserResponseDto> getAllUsers();

    CreateUserResponseDto getUserById(Long id);

    CreateUserResponseDto getUserByPinfl(String pinfl);
}