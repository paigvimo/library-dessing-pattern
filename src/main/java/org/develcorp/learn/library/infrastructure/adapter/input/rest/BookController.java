package org.develcorp.learn.library.infrastructure.adapter.input.rest;

import org.develcorp.learn.library.application.port.input.BookServiceInputPort;
import org.develcorp.learn.library.infrastructure.adapter.input.dto.BookDto;
import org.develcorp.learn.library.infrastructure.adapter.input.mapper.BookMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * REST Controller for managing Book operations.
 */
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookServiceInputPort bookService;
    private final BookMapper bookMapper = BookMapper.INSTANCE;

    public BookController(BookServiceInputPort bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<BookDto> saveBook(@RequestBody BookDto bookDto) {
        return bookService.saveBook(bookMapper.toEntity(bookDto))
                .map(bookMapper::toDto);
    }

    @GetMapping
    public Flux<BookDto> listBooks() {
        return bookService.listBooks()
                .map(bookMapper::toDto);
    }

    @GetMapping("/search")
    public Flux<BookDto> searchBooksByTitle(@RequestParam String title) {
        return bookService.searchBooksByTitle(title)
                .map(bookMapper::toDto);
    }
}