package dev.guilherme.scheduling.service;

import dev.guilherme.scheduling.dto.SchedulingDto;
import dev.guilherme.scheduling.entity.SchedulingEntity;
import dev.guilherme.scheduling.repository.SchedulingRepository;
import org.springframework.stereotype.Service;

@Service
public class SchedulingService {

    private final SchedulingRepository schedulingRepository;

    public SchedulingService(SchedulingRepository schedulingRepository) {
        this.schedulingRepository = schedulingRepository;
    }

    // Add methods to handle scheduling operations, such as create, update, delete, and retrieve schedules.

    public SchedulingEntity createScheduling(SchedulingEntity schedulingEntity) {
        return schedulingRepository.save(schedulingEntity);
    }
}
