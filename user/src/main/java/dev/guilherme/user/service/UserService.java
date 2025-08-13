package dev.guilherme.user.service;

import dev.guilherme.user.entity.UserEntity;
import dev.guilherme.user.exception.EmailAlreadyExistsException;
import dev.guilherme.user.producer.UserProducer;
import dev.guilherme.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository repository;
    private final UserProducer producer;

    public UserService(UserRepository repository, UserProducer producer) {
        this.repository = repository;
        this.producer = producer;
    }

    @Transactional
    public UserEntity saveAndPublishUser(UserEntity userEntity) {
        if (repository.existsByEmail(userEntity.getEmail())) {
            throw new EmailAlreadyExistsException(userEntity.getEmail());
        }
        userEntity = repository.save(userEntity);
        producer.publishEvent(userEntity);
        return userEntity;
    }

    public List<UserEntity> findAllUsers() {
        return repository.findAll();
    }

    public List<UserEntity> findUsersByName(String name) {
        return repository.findUsersByNameContainingIgnoreCase(name);
    }

    public UserEntity findUserByCode(Integer code) {
        return repository.findUserByUserCode(code);
    }

    public void deleteUserByCode(Integer code) {
        UUID userId = findUserByCode(code).getUserId();
        repository.deleteById(userId);
    }

    @Transactional
    public UserEntity updateUser(UserEntity userEntity, Integer userCode) {
        UserEntity existingUser = findUserByCode(userCode);
        existingUser.setName(userEntity.getName());
        existingUser.setEmail(userEntity.getEmail());
        return repository.save(existingUser);
    }
}
