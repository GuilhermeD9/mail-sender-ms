package dev.guilherme.scheduling.controller;

import dev.guilherme.scheduling.dto.SchedulingDto;
import dev.guilherme.scheduling.entity.SchedulingEntity;
import dev.guilherme.scheduling.service.SchedulingService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scheduling")
public class SchedulingController {
    private final SchedulingService schedulingService;

    public SchedulingController(SchedulingService schedulingService) {
        this.schedulingService = schedulingService;
    }

    @PostMapping
    public ResponseEntity<SchedulingEntity> createScheduling(@RequestBody SchedulingDto schedulingDto) {
        var schedulingEntity = new SchedulingEntity();
        BeanUtils.copyProperties(schedulingDto, schedulingEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(schedulingService.createScheduling(schedulingEntity));
    }

}
