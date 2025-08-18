package dev.guilherme.scheduling.dto;

import java.util.UUID;

public record UserDto(
        UUID userId,
        Integer userCode,
        String name,
        String email) {
}
