package br.com.desafio.serasa.desafio.domain.dto;

import br.com.desafio.serasa.desafio.domain.enums.RoleEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CredentialDTO {

    @NotBlank(message = "CAMPO_OBRIGATORIO")
    String email;

    @NotBlank(message = "CAMPO_OBRIGATORIO")
    String senha;

    @JsonIgnore
    List<RoleEnum> roles;
}
