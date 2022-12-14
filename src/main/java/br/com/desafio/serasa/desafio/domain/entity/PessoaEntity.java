package br.com.desafio.serasa.desafio.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Entity(name = "pessoa")
public class PessoaEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @CreationTimestamp
    @Column(name = "data_inclusao", nullable = false)
    private LocalDateTime dataInclusao;

    @Column(name = "nome", nullable = false)
    private String nome; //“Fulano de Tal”

    @Column(name = "telefone", nullable = false)
    private String telefone;//“99 99999-9999”

    @Column(name = "idade", nullable = false)
    private Integer idade;//99

    @Column(name = "score", nullable = false)
    private Integer score;// Entre 0 e 1000

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @Column(name = "regiao")
    private String regiao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PessoaEntity pessoa = (PessoaEntity) o;
        return id != null && Objects.equals(id, pessoa.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
