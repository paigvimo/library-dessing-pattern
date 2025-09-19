package org.develcorp.learn.library.domain.model.entity;


import org.develcorp.learn.library.domain.model.entity.enum.BookFormat;
import org.develcorp.learn.library.domain.model.entity.enum.BookStatus;
import org.develcorp.learn.library.domain.model.entity.enum.BookType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Book entity representing a book in the library system.
 * This entity is mapped to the 'books' table in the H2 database using R2DBC.
 * 
 * Attributes:
 * - id: Unique identifier for the book
 * - title: Title of the book
 * - author: Author of the book
 * - type: Type of book (Fiction/Non-fiction)
 * - format: Format of the book (Physical/Digital)
 * - status: Current status of the book (Available/Borrowed)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("books")
public class Book {

    @Id
    private Long id;

    @Column("title")
    private String title;

    @Column("author")
    private String author;

    @Column("type")
    private BookType type;

    @Column("format")
    private BookFormat format;

    @Column("status")
    private BookStatus status;
}