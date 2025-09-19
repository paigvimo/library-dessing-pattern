package org.develcorp.learn.library.infrastructure.adapter.input.mapper;

import org.develcorp.learn.library.domain.model.entity.Loan;
import org.develcorp.learn.library.infrastructure.adapter.input.dto.LoanDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper for converting between Loan and LoanDto.
 */
@Mapper
public interface LoanMapper {

    LoanMapper INSTANCE = Mappers.getMapper(LoanMapper.class);

    LoanDto toDto(Loan loan);

    Loan toEntity(LoanDto loanDto);
}