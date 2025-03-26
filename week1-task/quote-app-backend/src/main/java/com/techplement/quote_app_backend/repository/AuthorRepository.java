package com.techplement.quote_app_backend.repository;

import com.techplement.quote_app_backend.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByNameContainingIgnoreCase(String name);
    Author findByName(String name);
    List<Author> findByNameStartingWithIgnoreCase(String name);
}