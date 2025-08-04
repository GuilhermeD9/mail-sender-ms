package dev.guilherme.user.producer;

import dev.guilherme.user.dto.EmailDto;
import dev.guilherme.user.entity.UserEntity;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {
    private final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    private final String ROUTING_KEY = "email-queue";

    public void publishEvent(UserEntity userEntity) {
        var emailDto = new EmailDto();
        emailDto.setUserId(userEntity.getUserId());
        emailDto.setEmailTo(userEntity.getEmail());
        emailDto.setEmailSubject("This email is automatic.");
        emailDto.setBody("Hello " + userEntity.getName() + " Welcome!");

        rabbitTemplate.convertAndSend("", ROUTING_KEY, emailDto);
    }
}
