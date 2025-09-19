package org.develcorp.learn.library.domain.model.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity representing a loan of a book.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("loans")
public class Loan {

    @Id
    private Long id;

    @Column("book_id")
    private Long bookId;

    @Column("loan_date")
    private LocalDate loanDate;

    @Column("return_date")
    private LocalDate returnDate;

    @Column("borrower")
    private String borrower;
}