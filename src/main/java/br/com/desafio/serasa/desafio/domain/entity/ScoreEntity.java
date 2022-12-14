package br.com.desafio.serasa.desafio.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "score")
public class ScoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "inicial", nullable = false)
    private Integer valorInicial;

    @Column(name = "final", nullable = false)
    private Integer valorFinal;
}
