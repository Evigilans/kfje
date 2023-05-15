package com.epam.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/greeting")
public class GreetingController {

    @GetMapping
    public ResponseEntity<String> getGreeting() {
        return ResponseEntity.ok("Hello, k8s!");
    }
}
