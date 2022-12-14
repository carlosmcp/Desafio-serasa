package br.com.desafio.serasa.desafio.mapper;

import br.com.desafio.serasa.desafio.domain.dto.AfinidadeDTO;
import br.com.desafio.serasa.desafio.domain.entity.AfinidadeEntity;
import org.mapstruct.Mapper;

@Mapper
public interface AfinidadeMapper {

    AfinidadeEntity toEntity(AfinidadeDTO pessoa);

    AfinidadeDTO toDTO(AfinidadeEntity pessoa);
}
