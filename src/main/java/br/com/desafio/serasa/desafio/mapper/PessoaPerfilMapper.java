package br.com.desafio.serasa.desafio.mapper;

import br.com.desafio.serasa.desafio.domain.dto.PessoaPerfilDTO;
import br.com.desafio.serasa.desafio.domain.entity.PessoaEntity;
import org.mapstruct.Mapper;

@Mapper
public interface PessoaPerfilMapper {

    PessoaPerfilDTO toDTO(PessoaEntity pessoa);
}
