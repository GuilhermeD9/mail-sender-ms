package dev.guilherme.email.consumer;

import dev.guilherme.email.dto.EmailDto;
import dev.guilherme.email.entity.EmailEntity;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @RabbitListener(queues = "email-queue")
    public void listenEmailQueue(@Payload EmailDto emailDto) {
        var emailEntity = new EmailEntity();
        BeanUtils.copyProperties(emailDto, emailEntity);
    }
}
