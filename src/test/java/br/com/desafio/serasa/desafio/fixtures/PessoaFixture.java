package br.com.desafio.serasa.desafio.fixtures;

import br.com.desafio.serasa.desafio.domain.dto.EnderecoDTO;
import br.com.desafio.serasa.desafio.domain.dto.EstadoDTO;
import br.com.desafio.serasa.desafio.domain.dto.PessoaDTO;
import br.com.desafio.serasa.desafio.domain.dto.RegiaoDTO;
import br.com.desafio.serasa.desafio.domain.entity.PessoaEntity;

import java.time.LocalDateTime;

public class PessoaFixture {

    public static PessoaEntity buildEntity() {
        var entity = new PessoaEntity();
        entity.setId(1l);
        entity.setNome("Nome");
        entity.setRegiao("sudeste");
        entity.setCidade("São Paulo");
        entity.setScore(1000);
        entity.setDataInclusao(LocalDateTime.now());
        entity.setIdade(20);
        return entity;
    }

    public static PessoaDTO buildEntityDTO() {
        var dto = new PessoaDTO();
        dto.setId(1l);
        dto.setNome("Nome");
        dto.setTelefone("9999999");
        dto.setScore(1000);
        dto.setCep("68906855");
        dto.setIdade(20);
        return dto;
    }
    public static EnderecoDTO buildEnderecoDTO() {
        return new EnderecoDTO(
                "68908766",
                "",
                "",
                "",
                "",
                "SP",
                "",
                "",
                "11",
                "");
    }

    public static EstadoDTO buildEstadoDTO() {
        var regiao = new RegiaoDTO();
        regiao.setNome("Sudeste");
        return new EstadoDTO(1, "SP", "Nome", regiao);
    }
}
