package dev.guilherme.email.repository;

import dev.guilherme.email.entity.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmailRepository extends JpaRepository<EmailEntity, UUID> {
}
