package br.com.desafio.serasa.desafio.service;

import br.com.desafio.serasa.desafio.domain.entity.AfinidadeEntity;
import br.com.desafio.serasa.desafio.domain.interfaces.AfinidadeService;
import br.com.desafio.serasa.desafio.repository.AfinidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AfinidadeServiceImpl implements AfinidadeService {
    @Autowired
    private AfinidadeRepository repository;

    public AfinidadeEntity create(AfinidadeEntity afinidade) {
        return repository.save(afinidade);
    }

    public List<AfinidadeEntity> list() {
        return repository.findAll();
    }
}
