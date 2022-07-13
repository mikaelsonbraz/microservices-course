package com.mikaelsonbraz.bookservice.controllers;

import com.mikaelsonbraz.bookservice.models.Book;
import com.mikaelsonbraz.bookservice.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/book-service")
public class BookController {

    @Autowired
    private Environment environment;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping(value = "/{id}/{currency}")
    public Book getBook(@PathVariable("id") Long id,
                        @PathVariable("currency") String currency){
        Optional<Book> book = bookRepository.findById(id);
        if (book.isEmpty()) throw new RuntimeException("Book not found");
        String port = environment.getProperty("local.server.port");
        book.get().setEnvironment(port);
        return book.get();
    }
}
