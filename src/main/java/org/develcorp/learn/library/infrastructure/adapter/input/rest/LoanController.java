package org.develcorp.learn.library.infrastructure.adapter.input.rest;

import org.develcorp.learn.library.application.port.input.LoanServiceInputPort;
import org.develcorp.learn.library.infrastructure.adapter.input.dto.LoanDto;
import org.develcorp.learn.library.infrastructure.adapter.input.mapper.LoanMapper;
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
 * REST Controller for managing Loan operations.
 */
@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanServiceInputPort loanService;
    private final LoanMapper loanMapper = LoanMapper.INSTANCE;

    public LoanController(LoanServiceInputPort loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<LoanDto> saveLoan(@RequestBody LoanDto loanDto) {
        return loanService.saveLoan(loanMapper.toEntity(loanDto))
                .map(loanMapper::toDto);
    }

    @GetMapping
    public Flux<LoanDto> listLoans() {
        return loanService.listLoans()
                .map(loanMapper::toDto);
    }

    @GetMapping("/borrower")
    public Flux<LoanDto> findLoansByBorrower(@RequestParam String borrower) {
        return loanService.findLoansByBorrower(borrower)
                .map(loanMapper::toDto);
    }

    @GetMapping("/book")
    public Flux<LoanDto> findLoansByBookId(@RequestParam Long bookId) {
        return loanService.findLoansByBookId(bookId)
                .map(loanMapper::toDto);
    }
}