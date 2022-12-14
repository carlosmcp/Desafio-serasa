package br.com.desafio.serasa.desafio.controller;

import br.com.desafio.serasa.desafio.domain.dto.TokenDTO;
import br.com.desafio.serasa.desafio.domain.exception.NegocioException;
import br.com.desafio.serasa.desafio.util.MensagemUtil;
import br.com.desafio.serasa.desafio.util.TokenHelper;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.stream.Collectors;

@RestController
public class LogonController {

    @Autowired
    private MensagemUtil messageUtil;

    @Autowired
    private TokenHelper tokenHelper;

    @Operation(summary = "Realiza o logon e recupera um token de acesso")
    @PostMapping("/logon")
    public TokenDTO token(Authentication authentication) throws NegocioException, UnsupportedEncodingException {
        var roles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return tokenHelper.gerarToken(authentication.getName(), roles);
    }
}
