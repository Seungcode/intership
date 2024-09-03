package com.example.java_board.api.board.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateComment(
        @NotNull
        Long userId,
        @NotBlank
        String content
) {
}
