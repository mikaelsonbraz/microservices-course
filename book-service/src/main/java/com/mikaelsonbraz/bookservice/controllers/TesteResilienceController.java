package com.mikaelsonbraz.bookservice.controllers;

import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("book-service")
public class TesteResilienceController {

    private Logger logger = LoggerFactory.getLogger(TesteResilienceController.class);

    @GetMapping("/teste")
    @Retry(name = "book-service", fallbackMethod = "fallbackMethod")
    public String testeReesilience(){
        logger.info("Request for test is received!");
        ResponseEntity<String> response = new RestTemplate()
                .getForEntity("http://localhost:8080/teste", String.class);

        return response.getBody();
    }

    public String fallbackMethod(Exception exception){
        logger.info("Fallback Method called");
        return "Fallback Method";
    }
}
