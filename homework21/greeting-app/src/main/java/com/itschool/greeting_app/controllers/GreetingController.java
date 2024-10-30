package com.itschool.greeting_app.controllers;

import com.itschool.greeting_app.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @Autowired
    GreetingService greetingService;

    @GetMapping("/greet/{name}")
    public ResponseEntity<String> greet(@PathVariable String name){
        return ResponseEntity.ok(greetingService.getGreeting(name));
    }
}
