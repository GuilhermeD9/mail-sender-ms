package dev.guilherme.user.controller;

import dev.guilherme.user.dto.UserDto;
import dev.guilherme.user.entity.UserEntity;
import dev.guilherme.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserDto user) {
        var userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveAndPublishUser(userEntity));
    }
}
