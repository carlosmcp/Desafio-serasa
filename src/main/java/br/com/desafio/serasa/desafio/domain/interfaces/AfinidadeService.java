package br.com.desafio.serasa.desafio.domain.interfaces;

import br.com.desafio.serasa.desafio.domain.entity.AfinidadeEntity;

import java.util.List;

public interface AfinidadeService {

    AfinidadeEntity create(AfinidadeEntity afinidade);

    List<AfinidadeEntity> list();
}
