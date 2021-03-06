package com.mikaelsonbraz.cambioservice.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mikaelsonbraz.cambioservice.models.Cambio;
import com.mikaelsonbraz.cambioservice.repositories.CambioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Tag(name = "Cambio endpoints")
@RestController
@RequestMapping("/cambio-service")
public class CambioController {

    @Autowired
    private Environment environment;

    @Autowired
    private CambioRepository cambioRepository;

    // http://localhost:8000/cambio-service/5/USD/BRL
    @Operation(summary = "Converts a determined value from currency to another currency")
    @GetMapping(value = "/{amount}/{from}/{to}")
    public Cambio getCambio(@PathVariable("amount") BigDecimal amount,
                            @PathVariable("from") String from,
                            @PathVariable("to") String to){

        Cambio cambio = cambioRepository.findByFromAndTo(from, to);
        if (cambio == null) throw new RuntimeException("Currency unsupported");
        String port = environment.getProperty("local.server.port");
        BigDecimal conversionFactory = cambio.getConversionFactor();
        BigDecimal convertedValue = conversionFactory.multiply(amount);
        cambio.setConvertedValue(convertedValue.setScale(2, RoundingMode.CEILING));
        cambio.setEnvironment(port);
        return cambio;
    }
}
