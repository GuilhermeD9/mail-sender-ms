package dev.guilherme.scheduling.entity;

import dev.guilherme.scheduling.enums.SchedulingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class SchedulingEntity {

    private final static long serialVersionUUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID schedulingId;
    private Integer userCode;
    private String userEmail;
    private Integer professionalCode;
    private String professionalEmail;
    private LocalDate schedulingDate;
    private LocalTime schedulingTime;
    @Enumerated(EnumType.STRING)
    private SchedulingStatus schedulingStatus;
    private String description;
}
