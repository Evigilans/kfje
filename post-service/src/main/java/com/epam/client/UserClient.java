package com.epam.client;

import com.epam.model.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "user-updater", url = "http://userservice:8080/")
public interface UserClient {

    @GetMapping(value = "/users/{userId}", produces = "application/json")
    UserDto findUserById(@PathVariable("userId") long userId);

    @PutMapping(value = "/users/{userId}", produces = "application/json")
    void updateUser(@PathVariable("userId") long userId, @RequestBody UserDto userDto);
}
