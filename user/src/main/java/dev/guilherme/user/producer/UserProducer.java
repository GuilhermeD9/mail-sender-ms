package dev.guilherme.user.producer;

import dev.guilherme.user.configuration.RabbitMq;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {
    private final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public String produceMessage() {
        rabbitTemplate.convertAndSend(RabbitMq.EXCHANGE_NAME, "my-key.messages");
        return "A mensagem acaba de ser produzida pelo user.";
    }
}
