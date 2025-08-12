package dev.guilherme.scheduling.producer;

import dev.guilherme.scheduling.dto.EmailDto;
import dev.guilherme.scheduling.entity.SchedulingEntity;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class SchedulingProducer {

    private final RabbitTemplate rabbitTemplate;

    public SchedulingProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishEvent(SchedulingEntity schedulingEntity) {
        var emailDto = new EmailDto();
        emailDto.setUserId(schedulingEntity.getUserId());
        emailDto.setEmailTo(schedulingEntity.getUserEmail());
        emailDto.setEmailSubject("Novo Agendamento Cadastrado");
        emailDto.setBody(String.format("""
                    Olá, seu agendamento foi realizado com sucesso para o dia %s
                    no horário %s. Profissional responsável: %s.
                    """, schedulingEntity.getSchedulingDate(), schedulingEntity.getSchedulingTime(),schedulingEntity.getProfessionalId()));
    }
}
