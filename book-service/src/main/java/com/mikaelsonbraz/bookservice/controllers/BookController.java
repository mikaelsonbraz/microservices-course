package com.mikaelsonbraz.bookservice.controllers;

import com.mikaelsonbraz.bookservice.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;

@RestController
@RequestMapping("/book-service")
public class BookController {

    @Autowired
    private Environment environment;

    @GetMapping(value = "/{id}/{currency}")
    public Book getBook(@PathVariable("id") Long id,
                        @PathVariable("currency") String currency){
        String port = environment.getProperty("local.server.port");
        return new Book(1L, "Jorge Amado", "Capitães da Areia", new Date(), BigDecimal.valueOf(20), currency, port);
    }
}
