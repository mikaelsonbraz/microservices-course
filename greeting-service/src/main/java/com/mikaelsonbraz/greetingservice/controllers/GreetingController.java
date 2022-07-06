package com.mikaelsonbraz.greetingservice.controllers;

import com.mikaelsonbraz.greetingservice.config.GreetingConfig;
import com.mikaelsonbraz.greetingservice.models.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    @Autowired
    GreetingConfig greetingConfig;

    private static final String template = "%s, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public ResponseEntity<Greeting> greeting(@RequestParam(value = "name", defaultValue = "") String name){
        if (name.isEmpty()) name = greetingConfig.getDefaultValue();
        Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, greetingConfig.getGreeting(), name));
        return ResponseEntity.ok(greeting);
    }
}
