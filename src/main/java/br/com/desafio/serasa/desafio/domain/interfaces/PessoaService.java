package br.com.desafio.serasa.desafio.domain.interfaces;

import br.com.desafio.serasa.desafio.domain.entity.PessoaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PessoaService {

    PessoaEntity create(PessoaEntity pessoa, String cep);
    Optional<PessoaPerfilProjection> getById(Long id);
    Page<PessoaPerfilProjection> list(Pageable pageable);
    void removeById(Long id);
}
