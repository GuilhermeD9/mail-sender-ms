package dev.guilherme.scheduling.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record SchedulingDto(
        UUID userId,
        UUID professionalId,
        LocalDate schedulingDate,
        LocalTime schedulingTime,
        String description)
{}
