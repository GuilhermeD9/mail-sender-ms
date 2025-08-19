package dev.guilherme.scheduling.service;

import dev.guilherme.scheduling.dto.UserDto;
import dev.guilherme.scheduling.entity.SchedulingEntity;
import dev.guilherme.scheduling.enums.SchedulingStatus;
import dev.guilherme.scheduling.repository.SchedulingRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class SchedulingService {

    private final SchedulingRepository schedulingRepository;
    private final WebClient webClient;

    public SchedulingService(SchedulingRepository schedulingRepository, WebClient webClient) {
        this.schedulingRepository = schedulingRepository;
        this.webClient = webClient;
    }


    public SchedulingEntity createScheduling(SchedulingEntity schedulingEntity) {
        UserDto user = getCurrentUser(schedulingEntity.getUserCode());
        UserDto professional = getCurrentUser(schedulingEntity.getProfessionalCode());
        schedulingEntity.setUserEmail(user.email());
        schedulingEntity.setProfessionalEmail(professional.email());
        schedulingEntity.setSchedulingStatus(SchedulingStatus.PENDING);
        return schedulingRepository.save(schedulingEntity);
    }

    private UserDto getCurrentUser(Integer code) {
        return webClient.get()
                .uri("http://localhost:8081/users/code/{code}", code)
                .retrieve()
                .bodyToMono(UserDto.class)
                .block();
    }
}
