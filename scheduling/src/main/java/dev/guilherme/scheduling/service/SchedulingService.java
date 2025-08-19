package dev.guilherme.scheduling.service;

import dev.guilherme.scheduling.dto.UserDto;
import dev.guilherme.scheduling.entity.SchedulingEntity;
import dev.guilherme.scheduling.enums.SchedulingStatus;
import dev.guilherme.scheduling.producer.SchedulingProducer;
import dev.guilherme.scheduling.repository.SchedulingRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class SchedulingService {

    private final SchedulingRepository schedulingRepository;
    private final WebClient webClient;
    private final SchedulingProducer schedulingProducer;

    public SchedulingService(SchedulingRepository schedulingRepository,
                             WebClient webClient,
                             SchedulingProducer schedulingProducer) {
        this.schedulingRepository = schedulingRepository;
        this.webClient = webClient;
        this.schedulingProducer = schedulingProducer;
    }

    @Transactional
    public SchedulingEntity createScheduling(SchedulingEntity schedulingEntity) {
        UserDto user = getCurrentUser(schedulingEntity.getUserCode());
        UserDto professional = getCurrentUser(schedulingEntity.getProfessionalCode());
        schedulingEntity.setUserEmail(user.email());
        schedulingEntity.setProfessionalEmail(professional.email());
        schedulingEntity.setSchedulingStatus(SchedulingStatus.PENDING);
        schedulingProducer.publishEvent(schedulingEntity, user.userId());
        schedulingRepository.save(schedulingEntity);
        return schedulingEntity;
    }

    public UserDto getCurrentUser(Integer code) {
        return webClient.get()
                .uri("http://localhost:8081/users/code/{code}", code)
                .retrieve()
                .bodyToMono(UserDto.class)
                .block();
    }
}
