package com.example.gsp.dto.user;

import com.example.gsp.constant.enums.Gender;
import com.example.gsp.constant.enums.IdentificationDocument;

import java.time.LocalDate;

public record CreateUserResponseDto(
    Long id,
    String name,
    String address,
    String phoneNumber,
    String email,
    String photoUrl,
    String pinfl,
    Integer age,
    Gender gender,
    IdentificationDocument documentType,
    LocalDate issueDate,
    LocalDate expiryDate,
    String citizenship
) {}
