package dev.guilherme.scheduling.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record SchedulingDto(
        Integer userCode,
        Integer professionalCode,
        LocalDate schedulingDate,
        LocalTime schedulingTime,
        String description)
{}
