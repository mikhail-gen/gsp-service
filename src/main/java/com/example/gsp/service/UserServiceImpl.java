package com.example.gsp.service;

import com.example.gsp.dto.user.CreateUserRequestDto;
import com.example.gsp.dto.user.CreateUserResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserServiceImpl implements UserService{

    private final List<CreateUserResponseDto> users = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    // Create a new user
    public CreateUserResponseDto createUser(CreateUserRequestDto request) {
        CreateUserResponseDto user = new CreateUserResponseDto(
            idCounter.getAndIncrement(),
            request.name(),
            request.pinfl()
        );
        users.add(user);
        return user;
    }

    // Get all users
    public List<CreateUserResponseDto> getAllUsers() {
        return new ArrayList<>(users);
    }

    // Get user by ID
    public CreateUserResponseDto getUserById(Long id) {
        return users.stream()
            .filter(u -> u.id().equals(id))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    // Get user by PINFL
    public CreateUserResponseDto getUserByPinfl(String pinfl) {
        return users.stream()
            .filter(u -> u.pinfl().equals(pinfl))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("User not found with pinfl: " + pinfl));
    }
}
