package org.develcorp.learn.library.infrastructure.adapter.output.repository;

import io.r2dbc.spi.ConnectionFactory;
import org.develcorp.learn.library.domain.model.entity.Loan;
import org.develcorp.learn.library.infrastructure.adapter.output.config.DatabaseConnection;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Repository interface for managing Loan entities.
 */
public class LoanRepository {

    private final ConnectionFactory connectionFactory;

    public LoanRepository() {
        this.connectionFactory = DatabaseConnection.getInstance().getConnectionPool();
    }

    /**
     * Save a loan to the database.
     *
     * @param loan the loan to save
     * @return a Mono indicating the completion of the save operation
     */
    public Mono<Void> save(Loan loan) {
        return Mono.from(connectionFactory.create())
                .flatMap(connection -> connection.createStatement("INSERT INTO loans (id, book_id, loan_date, return_date, borrower) VALUES ($1, $2, $3, $4, $5)")
                        .bind("$1", loan.getId())
                        .bind("$2", loan.getBookId())
                        .bind("$3", loan.getLoanDate())
                        .bind("$4", loan.getReturnDate())
                        .bind("$5", loan.getBorrower())
                        .execute())
                .then();
    }

    /**
     * Find all loans in the database.
     *
     * @return a Flux of all loans
     */
    public Flux<Loan> findAll() {
        return Flux.from(connectionFactory.create())
                .flatMap(connection -> connection.createStatement("SELECT * FROM loans")
                        .execute())
                .flatMap(result -> result.map((row, rowMetadata) -> Loan.builder()
                        .id(row.get("id", Long.class))
                        .bookId(row.get("book_id", Long.class))
                        .loanDate(row.get("loan_date", LocalDate.class))
                        .returnDate(row.get("return_date", LocalDate.class))
                        .borrower(row.get("borrower", String.class))
                        .build()));
    }

    /**
     * Find loans by the borrower's name.
     *
     * @param borrower the name of the borrower
     * @return a Flux of loans matching the borrower
     */
    public Flux<Loan> findByBorrower(String borrower) {
        return Flux.from(connectionFactory.create())
                .flatMap(connection -> connection.createStatement("SELECT * FROM loans WHERE borrower = $1")
                        .bind("$1", borrower)
                        .execute())
                .flatMap(result -> result.map((row, rowMetadata) -> Loan.builder()
                        .id(row.get("id", Long.class))
                        .bookId(row.get("book_id", Long.class))
                        .loanDate(row.get("loan_date", LocalDate.class))
                        .returnDate(row.get("return_date", LocalDate.class))
                        .borrower(row.get("borrower", String.class))
                        .build()));
    }

    /**
     * Find loans by book ID.
     *
     * @param bookId the ID of the book
     * @return a Flux of loans matching the book ID
     */
    public Flux<Loan> findByBookId(Long bookId) {
        return Flux.from(connectionFactory.create())
                .flatMap(connection -> connection.createStatement("SELECT * FROM loans WHERE book_id = $1")
                        .bind("$1", bookId)
                        .execute())
                .flatMap(result -> result.map((row, rowMetadata) -> Loan.builder()
                        .id(row.get("id", Long.class))
                        .bookId(row.get("book_id", Long.class))
                        .loanDate(row.get("loan_date", LocalDate.class))
                        .returnDate(row.get("return_date", LocalDate.class))
                        .borrower(row.get("borrower", String.class))
                        .build()));
    }
}