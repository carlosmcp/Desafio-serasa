package br.com.desafio.serasa.desafio.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class PessoaPerfilDTO {
    private Long id;
    private String nome;
    private String cidade;
    private String estado;
    private String scoreDescricao;
    private List<String> estados;
}
