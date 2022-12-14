package br.com.desafio.serasa.desafio.domain.dto;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RestErrorDTO {
    Integer status;
    String message;
    List<CampoDTO> campos;
}
