package org.develcorp.learn.library.application.service;

import org.develcorp.learn.library.application.port.output.BookServiceInputPort;
import org.develcorp.learn.library.domain.model.entity.Book;
import org.develcorp.learn.library.infrastructure.adapter.output.repository.BookRepository;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service implementation for Book operations.
 */
@Service
public class BookService implements BookServiceInputPort {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Mono<Book> saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Flux<Book> listBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Flux<Book> searchBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
}