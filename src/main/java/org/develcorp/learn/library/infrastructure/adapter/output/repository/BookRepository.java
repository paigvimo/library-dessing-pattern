package org.develcorp.learn.library.infrastructure.adapter.output.repository;

import io.r2dbc.spi.ConnectionFactory;
import org.develcorp.learn.library.domain.model.entity.Book;
import org.develcorp.learn.library.infrastructure.adapter.output.config.DatabaseConnection;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Repository interface for managing Book entities.
 */
public class BookRepository {

    private final ConnectionFactory connectionFactory;

    public BookRepository() {
        this.connectionFactory = DatabaseConnection.getInstance().getConnectionPool();
    }

    /**
     * Save a book to the repository.
     *
     * @param book the book to save
     * @return a Mono indicating the completion of the save operation
     */
    public Mono<Void> save(Book book) {
        return Mono.from(connectionFactory.create())
                .flatMap(connection -> connection.createStatement("INSERT INTO books (id, title, author, type, format, status) VALUES ($1, $2, $3, $4, $5, $6)")
                        .bind("$1", book.getId())
                        .bind("$2", book.getTitle())
                        .bind("$3", book.getAuthor())
                        .bind("$4", book.getType().toString())
                        .bind("$5", book.getFormat().toString())
                        .bind("$6", book.getStatus().toString())
                        .execute())
                .then();
    }

    /**
     * Find all books in the repository.
     *
     * @return a Flux of all books
     */
    public Flux<Book> findAll() {
        return Flux.from(connectionFactory.create())
                .flatMap(connection -> connection.createStatement("SELECT * FROM books")
                        .execute())
                .flatMap(result -> result.map((row, rowMetadata) -> Book.builder()
                        .id(row.get("id", Long.class))
                        .title(row.get("title", String.class))
                        .author(row.get("author", String.class))
                        .type(BookType.valueOf(row.get("type", String.class)))
                        .format(BookFormat.valueOf(row.get("format", String.class)))
                        .status(BookStatus.valueOf(row.get("status", String.class)))
                        .build()));
    }

    /**
     * Find books by their title.
     *
     * @param title the title of the book
     * @return a Flux of books matching the title
     */
    public Flux<Book> findByTitle(String title) {
        return Flux.from(connectionFactory.create())
                .flatMap(connection -> connection.createStatement("SELECT * FROM books WHERE title = $1")
                        .bind("$1", title)
                        .execute())
                .flatMap(result -> result.map((row, rowMetadata) -> Book.builder()
                        .id(row.get("id", Long.class))
                        .title(row.get("title", String.class))
                        .author(row.get("author", String.class))
                        .type(BookType.valueOf(row.get("type", String.class)))
                        .format(BookFormat.valueOf(row.get("format", String.class)))
                        .status(BookStatus.valueOf(row.get("status", String.class)))
                        .build()));
    }
}