package com.techplement.quote_app_backend.service;

import com.techplement.quote_app_backend.dto.QuoteRequestDTO;
import com.techplement.quote_app_backend.model.Author;
import com.techplement.quote_app_backend.model.Quote;
import com.techplement.quote_app_backend.repository.AuthorRepository;
import com.techplement.quote_app_backend.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;

@Service
public class QuoteService {
    @Autowired
    private QuoteRepository quoteRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public Quote getQuoteOfTheDay() {
        List<Quote> quotes = quoteRepository.findAll();

        if (quotes.isEmpty()) {
            throw new RuntimeException("No quotes available.");
        }

        // Use current date to generate a seed
        LocalDate today = LocalDate.now(ZoneId.systemDefault());
        int seed = today.hashCode();

        // Create seeded random instance
        Random random = new Random(seed);
        int randomIndex = random.nextInt(quotes.size());

        return quotes.get(randomIndex);
    }

    public Quote saveQuote(QuoteRequestDTO quoteRequestDTO) {
        // Validate and fetch the Author
        Author author = authorRepository.findById(quoteRequestDTO.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + quoteRequestDTO.getAuthorId()));

        // Create and populate the Quote object
        Quote quote = new Quote();
        quote.setContent(quoteRequestDTO.getContent());
        quote.setAuthor(author);

        // Set dateAssigned (if not provided, use current date)
        quote.setCreatedAt(quoteRequestDTO.getDateAssigned() != null
                ? quoteRequestDTO.getDateAssigned()
                : LocalDate.now());

        return quoteRepository.save(quote);
    }

    public Quote updateQuote(Long quoteId, QuoteRequestDTO quoteRequestDTO) {
        // Fetch the existing quote
        Quote existingQuote = quoteRepository.findById(quoteId)
                .orElseThrow(() -> new RuntimeException("Quote not found with id: " + quoteId));

        // Validate and fetch the Author if authorId is provided
        Author author = authorRepository.findById(quoteRequestDTO.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + quoteRequestDTO.getAuthorId()));

        // Update fields
        existingQuote.setContent(quoteRequestDTO.getContent());
        existingQuote.setAuthor(author);

        // Update dateAssigned if provided, else keep the existing one
        if (quoteRequestDTO.getDateAssigned() != null) {
            existingQuote.setCreatedAt(quoteRequestDTO.getDateAssigned());
        }

        return quoteRepository.save(existingQuote);
    }

    public boolean deleteQuote(Long id) {
        if (quoteRepository.existsById(id)) {
            quoteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Quote> searchQuotesByAuthor(String authorName) {
        return quoteRepository.findByAuthorNameContainingIgnoreCase(authorName);
    }

    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }
}
