package org.develcorp.learn.library.application.service;

import org.develcorp.learn.library.application.port.input.LoanServiceInputPort;
import org.develcorp.learn.library.domain.model.entity.Loan;
import org.develcorp.learn.library.infrastructure.adapter.output.repository.LoanRepository;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service implementation for Loan operations.
 */
@Service
public class LoanService implements LoanServiceInputPort {

    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public Mono<Loan> saveLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public Flux<Loan> listLoans() {
        return loanRepository.findAll();
    }

    @Override
    public Flux<Loan> findLoansByBorrower(String borrower) {
        return loanRepository.findByBorrower(borrower);
    }

    @Override
    public Flux<Loan> findLoansByBookId(Long bookId) {
        return loanRepository.findByBookId(bookId);
    }
}