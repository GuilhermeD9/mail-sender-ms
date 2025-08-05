package dev.guilherme.user.controller;

import dev.guilherme.user.dto.UserDto;
import dev.guilherme.user.entity.UserEntity;
import dev.guilherme.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserDto user) {
        var userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveAndPublishUser(userEntity));
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<UserEntity>> getUserByName(@PathVariable String name) {
        List<UserEntity> users = userService.findUsersByName(name);
        if (users != null) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUserById(@RequestParam UUID id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<UserEntity> updateUserById(@RequestBody UserDto user, @RequestParam UUID uuid) {
        var userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        UserEntity updatedUser = userService.updateUser(userEntity, uuid);
        return ResponseEntity.ok(updatedUser);
    }
}
