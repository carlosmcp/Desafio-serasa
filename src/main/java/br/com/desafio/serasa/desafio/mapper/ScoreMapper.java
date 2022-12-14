package br.com.desafio.serasa.desafio.mapper;

import br.com.desafio.serasa.desafio.domain.dto.ScoreDTO;
import br.com.desafio.serasa.desafio.domain.entity.ScoreEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ScoreMapper {
    ScoreEntity toEntity(ScoreDTO pessoa);

    @Mapping(source = "descricao", target = "descricao")
    @Mapping(source = "valorInicial", target = "valorInicial")
    @Mapping(source = "valorFinal", target = "valorFinal")
    ScoreDTO toDTO(ScoreEntity pessoa);
}
