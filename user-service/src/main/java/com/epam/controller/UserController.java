package com.epam.controller;

import com.epam.model.User;
import com.epam.model.dto.UserDto;
import com.epam.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<User> findUserById(@PathVariable long userId) {
        Optional<User> optionalUser = userService.findUserById(userId);
        return optionalUser.map(user -> ResponseEntity.ok().body(user)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
        User user = userService.createUser(userDto);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable long userId, @RequestBody UserDto userDto) {
        log.info("Put invoked");
        User user = userService.updateUser(userId, userDto);
        return user == null ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.noContent().build();
    }
}
