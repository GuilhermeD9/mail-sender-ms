package dev.guilherme.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.util.UUID;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Table(name = "TB_USERS")
public class UserEntity {

    private static final long serialVersionUUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    @Generated(event = EventType.INSERT)
    @Column(unique = true, nullable = false, insertable = false, updatable = false)
    private Integer userCode;

    private String name;
    private String email;
}
