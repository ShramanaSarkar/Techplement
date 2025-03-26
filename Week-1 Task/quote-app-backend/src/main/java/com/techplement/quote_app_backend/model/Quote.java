package com.techplement.quote_app_backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String content;

    @Column
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    // Custom constructor to create Quote with content and author
    public Quote(String content, Author author, LocalDate createdAt) {
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;

    }

}

