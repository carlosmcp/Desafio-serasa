package br.com.desafio.serasa.desafio.util;

import br.com.desafio.serasa.desafio.domain.enums.MensagemEnum;
import org.apache.commons.lang3.LocaleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class MensagemUtil {

    @Value("${i18n.defaultLocale}")
    private String defaultLocale;

    @Autowired
    private MessageSource messageSource;

    public String getMessage(MensagemEnum mensagem) {
        return messageSource.getMessage(mensagem.getValor(), null, LocaleUtils.toLocale(defaultLocale));
    }

    public String getMessageInterpolate(MensagemEnum mensagem, Object...args) {
        return messageSource.getMessage(mensagem.getValor(), args, LocaleUtils.toLocale(defaultLocale));
    }

}
