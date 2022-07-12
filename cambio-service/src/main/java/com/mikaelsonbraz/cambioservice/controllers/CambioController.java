package com.mikaelsonbraz.cambioservice.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mikaelsonbraz.cambioservice.models.Cambio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.ElementType;
import java.math.BigDecimal;

@RestController
@RequestMapping("/cambio-service")
public class CambioController {

    // http://localhost:8000/cambio-service/5/USD/BRL
    @GetMapping(value = "/{amount}/{from}/{to}")
    public Cambio getCambio(@PathVariable("amount") BigDecimal amount,
                            @PathVariable("from") String from,
                            @PathVariable("to") String to){
        return new Cambio(1L, from, to, BigDecimal.ONE, BigDecimal.ONE, "PORT: 8000");
    }
}
