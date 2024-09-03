package com.example.java_board.api.board.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record UpdateBoard(
        @NotNull
        Long userId,
        @NotBlank
        String title,
        @NotBlank
        String content
) {
}


