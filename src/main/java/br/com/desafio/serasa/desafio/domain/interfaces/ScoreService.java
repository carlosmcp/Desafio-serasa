package br.com.desafio.serasa.desafio.domain.interfaces;

import br.com.desafio.serasa.desafio.domain.entity.ScoreEntity;

import java.util.List;

public interface ScoreService {
    ScoreEntity create(ScoreEntity score);
    List<ScoreEntity> list();
}
