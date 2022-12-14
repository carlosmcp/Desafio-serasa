package br.com.desafio.serasa.desafio.service;

import br.com.desafio.serasa.desafio.domain.entity.ScoreEntity;
import br.com.desafio.serasa.desafio.domain.interfaces.ScoreService;
import br.com.desafio.serasa.desafio.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreRepository repository;

    public ScoreEntity create(ScoreEntity score) {
        return repository.save(score);
    }

    public List<ScoreEntity> list() {
        return repository.findAll();
    }
}
