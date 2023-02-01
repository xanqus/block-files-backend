package com.example.flowpre_assignment.domain.dto;

import java.time.LocalDateTime;

public record BlockFileExtensionDto(
        Long id,
        String extensionKeyword,
        LocalDateTime createdAt
) {
}
