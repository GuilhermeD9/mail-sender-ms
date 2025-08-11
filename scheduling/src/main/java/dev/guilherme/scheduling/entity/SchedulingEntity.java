package dev.guilherme.scheduling.entity;

import dev.guilherme.scheduling.enums.SchedulingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
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
    private UUID clientId;
    private UUID professionalId;
    private LocalDateTime schedulingDate;
    @Enumerated(EnumType.STRING)
    private SchedulingStatus schedulingStatus;
}
