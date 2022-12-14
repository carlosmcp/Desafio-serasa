package br.com.desafio.serasa.desafio.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class AfinidadeDTO {
    @NotBlank(message = "CAMPO_OBRIGATORIO")
    private String regiao;

    @NotBlank(message = "CAMPO_OBRIGATORIO")
    private List<String> estados;
}
