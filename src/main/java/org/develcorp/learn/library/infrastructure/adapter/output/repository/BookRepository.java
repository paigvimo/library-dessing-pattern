package org.develcorp.learn.library.infrastructure.adapter.output.repository;

import org.develcorp.learn.library.domain.model.entity.Book;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

/**
 * Repository interface for managing Book entities.
 */
public interface BookRepository extends ReactiveCrudRepository<Book, Long> {

    /**
     * Find books by their title.
     *
     * @param title the title of the book
     * @return a Flux of books matching the title
     */
    Flux<Book> findByTitle(String title);
}