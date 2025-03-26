package com.techplement.quote_app_backend.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class QuoteRequestDTO {
    private String content;
    private Long authorId;
    private LocalDate dateAssigned; // Optional, if not provided, assign current date
}