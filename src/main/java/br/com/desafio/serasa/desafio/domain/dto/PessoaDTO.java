package br.com.desafio.serasa.desafio.domain.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PessoaDTO {
    private Long id;

    @NotBlank(message = "CAMPO_OBRIGATORIO")
    private String nome;

    @NotBlank(message = "CAMPO_OBRIGATORIO")
    private String telefone;

    @Min(value = 0L, message = "CAMPO_POSITIVO")
    @NotNull(message = "CAMPO_OBRIGATORIO")
    private Integer idade;

    @NotBlank(message = "CAMPO_OBRIGATORIO")
    private String cep;

    @NotNull(message = "CAMPO_OBRIGATORIO")
    @Min(value = 0L, message = "CAMPO_POSITIVO")
    private Integer score;
}
