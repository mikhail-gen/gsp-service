package com.example.gsp.dto.user;

import jakarta.validation.constraints.NotBlank;

public record CreateUserRequestDto(
    @NotBlank String name,
    @NotBlank String pinfl
) {}