package com.itschool.greeting_app.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getGreeting(String name){
        return "Hello, " + name + "!";
    }
}
