package br.com.desafio.serasa.desafio.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EstadoDTO {
    private Integer id;
    private String sigla;
    private String nome;
    private RegiaoDTO regiao;
}
