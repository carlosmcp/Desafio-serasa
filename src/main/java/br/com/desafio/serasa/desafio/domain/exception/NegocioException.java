package br.com.desafio.serasa.desafio.domain.exception;

import br.com.desafio.serasa.desafio.domain.enums.MensagemEnum;

public class NegocioException extends Exception {

    public NegocioException(MensagemEnum message) {
        super(message.name());
    }
}
