package br.com.desafio.serasa.desafio.fixtures;

import br.com.desafio.serasa.desafio.domain.entity.AfinidadeEntity;

import java.util.List;

public class AfinidadeFixture {
    public static AfinidadeEntity buildAfinidadeEntity() {
        var entity = new AfinidadeEntity();
        entity.setId(1l);
        entity.setRegiao("sudeste");
        entity.setEstados(List.of("SP","RJ","MG","ES"));
        return entity;
    }
}
