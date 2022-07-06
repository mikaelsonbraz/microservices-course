package com.mikaelsonbraz.greetingservice.controllers;

import com.mikaelsonbraz.greetingservice.models.Greeting;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public ResponseEntity<Greeting> greeting(@RequestParam(value = "name", defaultValue = "world") String name){
        Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));
        return ResponseEntity.ok(greeting);
    }
}
