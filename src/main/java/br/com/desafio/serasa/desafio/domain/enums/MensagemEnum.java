package br.com.desafio.serasa.desafio.domain.enums;

public enum MensagemEnum {

    CAMPO_OBRIGATORIO("mandatory.field"),
    VALIDACAO_CAMPO("validation.error"),
    REGISTRO_NAO_ENCONTRADO("not.found"),
    SISTEMA_INDISPONIVEL("server.unavailable"),

    CAMPO_POSITIVO("positive.value"),

    LOGIN_ERROR("login.error")
    ;

    private String valor;

    MensagemEnum(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
