package br.com.desafio.serasa.desafio.repository;

import br.com.desafio.serasa.desafio.domain.entity.ScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<ScoreEntity, Long> {

}
