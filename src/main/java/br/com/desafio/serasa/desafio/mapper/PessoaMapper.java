package br.com.desafio.serasa.desafio.mapper;

import br.com.desafio.serasa.desafio.domain.dto.PessoaDTO;
import br.com.desafio.serasa.desafio.domain.entity.PessoaEntity;
import org.mapstruct.Mapper;

@Mapper
public interface PessoaMapper {

    PessoaEntity toEntity(PessoaDTO pessoa);

    PessoaDTO toDTO(PessoaEntity pessoa);


}
