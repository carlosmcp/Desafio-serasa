package br.com.desafio.serasa.desafio.repository;

import br.com.desafio.serasa.desafio.domain.entity.PessoaEntity;
import br.com.desafio.serasa.desafio.domain.interfaces.PessoaPerfilProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {
    @Query(
            value = "SELECT P.NOME, P.CIDADE, P.ESTADO, S.DESCRICAO, A.ESTADOS " +
                    "FROM PESSOA P JOIN AFINIDADE A ON (A.REGIAO = P.REGIAO) " +
                    "JOIN SCORE S ON (P.SCORE BETWEEN S.INICIAL AND S.FINAL)",

            countQuery = "SELECT COUNT(*) FROM PESSOA P JOIN AFINIDADE A ON (A.REGIAO = P.REGIAO) " +
                    " JOIN SCORE S ON (P.SCORE BETWEEN S.INICIAL AND S.FINAL)",
            nativeQuery = true)
    Page<PessoaPerfilProjection> findPerfilWithPagination(Pageable pageable);

    @Query(
            value = "SELECT P.NOME, P.CIDADE, P.ESTADO, S.DESCRICAO, A.ESTADOS " +
                    "FROM PESSOA P JOIN AFINIDADE A ON (A.REGIAO = P.REGIAO) " +
                    "JOIN SCORE S ON (P.SCORE BETWEEN S.INICIAL AND S.FINAL)" +
                    "WHERE P.ID = :id",
            nativeQuery = true)
    PessoaPerfilProjection findOne(@Param("id") Long id);

}
