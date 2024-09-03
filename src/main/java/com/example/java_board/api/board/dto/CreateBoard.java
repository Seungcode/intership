package com.example.java_board.api.board.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record CreateBoard(
        @NotNull
        Long userId,
        @NotBlank
        String title,
        @NotBlank
        String content
) {
}


