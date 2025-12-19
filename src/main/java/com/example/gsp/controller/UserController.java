package com.example.gsp.controller;

import com.example.gsp.dto.user.CreateUserRequestDto;
import com.example.gsp.dto.user.CreateUserResponseDto;
import com.example.gsp.service.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gcp/users")
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<CreateUserResponseDto> createUser(@Valid @RequestBody CreateUserRequestDto request) {
        CreateUserResponseDto response = userService.createUser(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<CreateUserResponseDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/by-id/{id}")
    public ResponseEntity<CreateUserResponseDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/by-pinfl/{pinfl}")
    public ResponseEntity<CreateUserResponseDto> getUserByPinfl(@PathVariable String pinfl) {
        return ResponseEntity.ok(userService.getUserByPinfl(pinfl));
    }
}