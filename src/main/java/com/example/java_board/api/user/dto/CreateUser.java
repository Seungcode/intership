package com.example.java_board.api.user.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateUser(
        @NotBlank
        String email,
        @NotBlank
        String password
) {
}
