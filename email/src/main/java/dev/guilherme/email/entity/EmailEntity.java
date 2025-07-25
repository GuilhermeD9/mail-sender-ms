package dev.guilherme.email.entity;

import dev.guilherme.email.enums.EmailStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailEntity {

    private final long serialVersioUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID emailId;
    private UUID userId;
    private String emailFrom;
    private String emailTo;
    private String emailSubject;
    @Column(columnDefinition = "TEXT")
    private String body;
    private LocalDateTime sendAt;
    private EmailStatus emailStatus;
}
