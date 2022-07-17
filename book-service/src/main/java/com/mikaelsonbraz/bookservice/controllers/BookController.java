package com.mikaelsonbraz.bookservice.controllers;

import com.mikaelsonbraz.bookservice.models.Book;
import com.mikaelsonbraz.bookservice.proxy.CambioProxy;
import com.mikaelsonbraz.bookservice.repositories.BookRepository;
import com.mikaelsonbraz.bookservice.response.Cambio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/book-service")
public class BookController {

    @Autowired
    private Environment environment;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CambioProxy cambioProxy;

    @GetMapping(value = "/{id}/{currency}")
    public Book getBook(@PathVariable("id") Long id,
                        @PathVariable("currency") String currency){
        Optional<Book> book = bookRepository.findById(id);
        if (book.isEmpty()) throw new RuntimeException("Book not found");

        Cambio cambio = cambioProxy.getCambio(book.get().getPrice(), "USD", currency);

        String port = environment.getProperty("local.server.port");
        book.get().setEnvironment("BOOK SERVICE PORT: " + port + " _ CAMBIO SERVICE PORT: " + cambio.getEnvironment());
        book.get().setPrice(cambio.getConvertedValue());
        return book.get();
    }
}
