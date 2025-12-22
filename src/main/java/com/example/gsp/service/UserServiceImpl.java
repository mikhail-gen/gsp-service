package com.example.gsp.service;

import com.example.gsp.dto.user.CreateUserRequestDto;
import com.example.gsp.dto.user.CreateUserResponseDto;
import com.example.gsp.entity.User;
import com.example.gsp.mapper.UserMapper;
import com.example.gsp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public CreateUserResponseDto createUser(CreateUserRequestDto request) {
        User user = userMapper.toEntity(request);
        User savedUser = userRepository.save(user);
        return userMapper.toResponseDto(savedUser);
    }

    @Override
    public List<CreateUserResponseDto> getAllUsers() {
        return userRepository.findAll()
            .stream()
            .map(userMapper::toResponseDto)
            .toList();
    }

    @Override
    @Cacheable(value = "users", key = "#id")
    public CreateUserResponseDto getUserById(Long id) {
        return userRepository.findById(id)
            .map(userMapper::toResponseDto)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public CreateUserResponseDto getUserByPinfl(String pinfl) {
        return userRepository.findByPinfl(pinfl)
            .map(userMapper::toResponseDto)
            .orElseThrow(() -> new RuntimeException("User not found with pinfl: " + pinfl));
    }
}