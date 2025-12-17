package com.example.gsp.dto;

import com.example.gsp.constant.enums.ErrorType;
import lombok.Builder;

import java.util.List;

@Builder
public record ErrorDto(
    int code,
    String message,
    ErrorType type,
    List<String> validationErrors) {}