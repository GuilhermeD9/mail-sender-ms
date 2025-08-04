package dev.guilherme.user.service;

import dev.guilherme.user.entity.UserEntity;
import dev.guilherme.user.producer.UserProducer;
import dev.guilherme.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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
        userEntity = repository.save(userEntity);
        producer.publishEvent(userEntity);
        return userEntity;
    }
}
