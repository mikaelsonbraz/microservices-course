package com.mikaelsonbraz.bookservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book-service")
public class TesteResilienceController {

    @GetMapping("/teste")
    public String testeReesilience(){
        return "Teste do Resilience4j";
    }
}
