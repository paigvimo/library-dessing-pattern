package org.develcorp.learn.library.domain.port;

import org.develcorp.learn.library.domain.model.Book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Port interface for Book service operations.
 */
public interface BookServicePort {

    /**
     * Save a book.
     *
     * @param book the book to save
     * @return a Mono of the saved book
     */
    Mono<Book> saveBook(Book book);

    /**
     * List all books.
     *
     * @return a Flux of all books
     */
    Flux<Book> listBooks();

    /**
     * Search books by title.
     *
     * @param title the title to search for
     * @return a Flux of books matching the title
     */
    Flux<Book> searchBooksByTitle(String title);
}