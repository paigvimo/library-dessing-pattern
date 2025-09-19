package org.develcorp.learn.library.infrastructure.adapter.input.mapper;

import org.develcorp.learn.library.domain.model.entity.Book;
import org.develcorp.learn.library.infrastructure.adapter.input.dto.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper for converting between Book and BookDto.
 */
@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDto toDto(Book book);

    Book toEntity(BookDto bookDto);
}