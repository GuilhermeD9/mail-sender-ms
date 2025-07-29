package dev.guilherme.user.service;

import dev.guilherme.user.entity.UserEntity;
import dev.guilherme.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public UserEntity createUser(UserEntity userEntity) {
        return userEntity = repository.save(userEntity);
    }
}
