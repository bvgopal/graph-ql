package com.example.graphql.controller;

import com.example.graphql.model.Author;
import com.example.graphql.repository.AuthorRepository;
import com.example.graphql.model.Book;
import com.example.graphql.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @QueryMapping
    public Iterable<Author> authors() {
        return authorRepository.findAll();
    }

    @QueryMapping
    public Optional<Author> authorById(@Argument Long id) {
        return authorRepository.findById(id);
    }

    @MutationMapping
    public Book addBook(@Argument BookInput book) {
        Author author= authorRepository.findById(book.authorId()).orElseThrow(() -> new IllegalArgumentException("Author Not found"));
        Book b = new Book(book.title(), book.publisher(), author);
        return bookRepository.save(b);
    }
    record BookInput(String title, String publisher, Long authorId) {}

}
