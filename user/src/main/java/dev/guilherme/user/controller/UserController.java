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

    @GetMapping("/name")
    public ResponseEntity<List<UserEntity>> getUserByName(@RequestParam String name) {
        List<UserEntity> users = userService.findUsersByName(name);
        if (users != null) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<UserEntity> getUserByCode(@PathVariable Integer code) {
        UserEntity user = userService.findUserByCode(code);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteUserByCode(@PathVariable Integer code) {
        userService.deleteUserByCode(code);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{userCode}")
    public ResponseEntity<UserEntity> updateUserById(@RequestBody UserDto user, @PathVariable Integer userCode) {
        var userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        UserEntity updatedUser = userService.updateUser(userEntity, userCode);
        return ResponseEntity.ok(updatedUser);
    }
}
