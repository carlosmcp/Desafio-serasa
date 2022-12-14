package br.com.desafio.serasa.desafio.domain.interfaces;

import java.util.List;

public interface PessoaPerfilProjection {
    String getNome();
    String getCidade();
    String getEstado();
    String getdescricao();
    List<String> getestados();
}
