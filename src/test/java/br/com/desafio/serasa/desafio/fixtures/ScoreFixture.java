package br.com.desafio.serasa.desafio.fixtures;

import br.com.desafio.serasa.desafio.domain.dto.ScoreDTO;
import br.com.desafio.serasa.desafio.domain.entity.ScoreEntity;

public class ScoreFixture {

    public static ScoreEntity buildEntity() {
        var entity = new ScoreEntity();
        entity.setId(1l);
        entity.setDescricao("Recomendável");
        entity.setValorInicial(701);
        entity.setValorFinal(1000);
        return entity;
    }

    public static ScoreDTO buildEntityDTO() {
        var dto = new ScoreDTO();
        dto.setId(1l);
        dto.setDescricao("Recomendável");
        dto.setValorInicial(701);
        dto.setValorFinal(1000);
        return dto;
    }
}
