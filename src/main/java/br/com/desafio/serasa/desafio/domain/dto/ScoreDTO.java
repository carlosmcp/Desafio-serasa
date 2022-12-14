package br.com.desafio.serasa.desafio.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ScoreDTO {

    @JsonIgnore
    private Long id;

    @JsonProperty("scoreDescricao")
    private String descricao;

    @JsonProperty("inicial")
    private Integer valorInicial;

    @JsonProperty("final")
    private Integer valorFinal;
}
