package com.example.gsp.dto.user;

import com.example.gsp.constant.enums.Gender;
import com.example.gsp.constant.enums.IdentificationDocument;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record CreateUserRequestDto(
    @NotBlank(message = "Full name is required")
    @Size(min = 1, max = 100, message = "Full name must be between 1 and 100 characters")
    String name,

    @NotBlank(message = "Address is required")
    @Size(min = 1, max = 255, message = "Address must be between 1 and 255 characters")
    String address,

    @NotBlank(message = "Phone number is required")
    @Pattern(
        regexp = "^\\+?[0-9]{9,15}$",
        message = "Invalid phone number format"
    )
    String phoneNumber,

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be a valid email address")
    String email,

    String photoUrl,

    @NotBlank(message = "PINFL is required")
    @Size(min = 14, max = 14, message = "PINFL must be exactly 14 characters")
    String pinfl,

    @NotNull(message = "Age is required")
    @Positive(message = "Age must be a positive number")
    @Min(value = 0, message = "Age must be at least 0")
    @Max(value = 150, message = "Age must not exceed 150")
    Integer age,

    @NotNull(message = "Gender is required")
    Gender gender,

    @NotNull(message = "Identification Document is required")
    IdentificationDocument documentType,

    @NotNull(message = "Issue date is required")
    @Past(message = "Issue date must be in the past")
    LocalDate issueDate,

    @NotNull(message = "Expiry date is required")
    @Future(message = "Expiry date must be in the future or present")
    LocalDate expiryDate,

    @NotBlank(message = "Citizenship is required")
    @Size(min = 2, max = 100, message = "Citizenship must be between 2 and 100 characters")
    String citizenship
) {
}