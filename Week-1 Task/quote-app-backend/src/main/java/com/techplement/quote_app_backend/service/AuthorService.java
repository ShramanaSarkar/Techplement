package com.techplement.quote_app_backend.service;

import com.techplement.quote_app_backend.model.Author;
import com.techplement.quote_app_backend.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author getAuthor(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author updateAuthor(Long id, Author author) {
        author.setId(id);
        return authorRepository.save(author);
    }

    public boolean deleteAuthor(Long id) {
        if (authorRepository.existsById(id)) {
            authorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public List<String> searchAuthorsByName(String name) {
        // Fetch matching authors using the repository
        return authorRepository.findByNameStartingWithIgnoreCase(name)
                .stream()
                .map(Author::getName)
                .collect(Collectors.toList());
    }
}