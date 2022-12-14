package br.com.desafio.serasa.desafio.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "afinidade")
public class AfinidadeEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "regiao", nullable = false,  unique = true)
    private String regiao; //“regiao”: “sudeste”,

    @Column(name = "estados", nullable = false, length = 2)
    private List<String> estados; //“regiao”: “sudeste”,
}
