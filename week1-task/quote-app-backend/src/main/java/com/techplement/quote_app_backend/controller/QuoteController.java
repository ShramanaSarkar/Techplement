package com.techplement.quote_app_backend.controller;

import com.techplement.quote_app_backend.dto.QuoteRequestDTO;
import com.techplement.quote_app_backend.model.ApiResponse;
import com.techplement.quote_app_backend.model.Quote;
import com.techplement.quote_app_backend.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quotes")
@CrossOrigin(origins = "http://localhost:3000")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @GetMapping("/quote-of-the-day")
    public ResponseEntity<Quote> getQuoteOfTheDay() {
        return ResponseEntity.ok(quoteService.getQuoteOfTheDay());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Quote>> searchQuotesByAuthor(@RequestParam String authorName) {
        return ResponseEntity.ok(quoteService.searchQuotesByAuthor(authorName));
    }

    @PostMapping
    public Quote saveQuote(@RequestBody QuoteRequestDTO quoteRequestDTO) {
        return quoteService.saveQuote(quoteRequestDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Quote> updateQuote(@PathVariable Long id, @RequestBody QuoteRequestDTO quoteRequestDTO) {
        return ResponseEntity.ok(quoteService.updateQuote(id, quoteRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteQuote(@PathVariable Long id) {
        boolean isDeleted = quoteService.deleteQuote(id);

        if (isDeleted) {
            return ResponseEntity.ok(new ApiResponse(true, "Quote deleted successfully."));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(false, "Quote not found with id: " + id));
        }
    }

    @GetMapping()
    public ResponseEntity<List<Quote>> getAllQuotes() {
        return ResponseEntity.ok(quoteService.getAllQuotes());
    }
}
