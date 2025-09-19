package org.develcorp.learn.library.application.port.input;

import org.develcorp.learn.library.domain.model.entity.Loan;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Port interface for Loan service operations.
 */
public interface LoanServiceInputPort {

    /**
     * Save a loan.
     *
     * @param loan the loan to save
     * @return a Mono of the saved loan
     */
    Mono<Loan> saveLoan(Loan loan);

    /**
     * List all loans.
     *
     * @return a Flux of all loans
     */
    Flux<Loan> listLoans();

    /**
     * Find loans by borrower.
     *
     * @param borrower the name of the borrower
     * @return a Flux of loans matching the borrower
     */
    Flux<Loan> findLoansByBorrower(String borrower);

    /**
     * Find loans by book ID.
     *
     * @param bookId the ID of the book
     * @return a Flux of loans matching the book ID
     */
    Flux<Loan> findLoansByBookId(Long bookId);
}