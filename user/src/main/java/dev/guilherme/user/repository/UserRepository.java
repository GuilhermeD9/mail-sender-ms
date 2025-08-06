package dev.guilherme.user.repository;

import dev.guilherme.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    List<UserEntity> findUsersByName(String name);

    boolean existsByEmail(String email);
}
