package com.mikaelsonbraz.bookservice.controllers;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Book service endpoints testing")
@RestController
@RequestMapping("book-service")
public class TesteResilienceController {

    private Logger logger = LoggerFactory.getLogger(TesteResilienceController.class);

    @Operation(summary = "Testing @Retry, @CircuitBreaker, @Bulkhead, @RateLimiter and FallbackMethods")
    @GetMapping("/teste")
    //@Retry(name = "book-service", fallbackMethod = "fallbackMethod")
    //@CircuitBreaker(name = "book-service", fallbackMethod = "fallbackMethod")
    //@RateLimiter(name = "book-service")
    @Bulkhead(name = "book-service")
    public String testeResilience(){
        logger.info("Request for test is received!");
        /*
        ResponseEntity<String> response = new RestTemplate()
                .getForEntity("http://localhost:8080/teste", String.class);
        return response.getBody();
         */
        return "Teste Ratelimiter - 2 for period, 10s for refresh period";
    }

    public String fallbackMethod(Exception exception){
        logger.info("Fallback Method called");
        return "Fallback Method";
    }
}
