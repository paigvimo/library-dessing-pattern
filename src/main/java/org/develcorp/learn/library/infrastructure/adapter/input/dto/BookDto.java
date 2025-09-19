package org.develcorp.learn.library.infrastructure.adapter.input.dto;

import org.develcorp.learn.library.domain.model.entity.enums.BookFormat;
import org.develcorp.learn.library.domain.model.entity.enums.BookStatus;
import org.develcorp.learn.library.domain.model.entity.enums.BookType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for Book entity.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {

    private Long id;
    private String title;
    private String author;
    private BookType type;
    private BookFormat format;
    private BookStatus status;
}