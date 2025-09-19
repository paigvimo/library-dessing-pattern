package org.develcorp.learn.library.infrastructure.adapter.output.repository;

import org.develcorp.learn.library.domain.model.entity.Loan;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

/**
 * Repository interface for managing Loan entities.
 */
public interface LoanRepository extends ReactiveCrudRepository<Loan, Long> {

    /**
     * Find loans by the borrower's name.
     *
     * @param borrower the name of the borrower
     * @return a Flux of loans matching the borrower
     */
    Flux<Loan> findByBorrower(String borrower);

    /**
     * Find loans by book ID.
     *
     * @param bookId the ID of the book
     * @return a Flux of loans matching the book ID
     */
    Flux<Loan> findByBookId(Long bookId);
}