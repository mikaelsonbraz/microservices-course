package com.mikaelsonbraz.bookservice.repositories;

import com.mikaelsonbraz.bookservice.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
