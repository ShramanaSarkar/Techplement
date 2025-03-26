package com.techplement.quote_app_backend.repository;

import com.techplement.quote_app_backend.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
    Optional<Quote> findByCreatedAt(LocalDate date);
    List<Quote> findByAuthorNameContainingIgnoreCase(String authorName);
}