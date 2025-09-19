package org.develcorp.learn.library.infrastructure.adapter.input.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for Loan entity.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanDto {

    private Long id;
    private Long bookId;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private String borrower;
}