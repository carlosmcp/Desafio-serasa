package br.com.desafio.serasa.desafio.util;

import br.com.desafio.serasa.desafio.domain.dto.TokenDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TokenHelper {

    private Logger logger = LoggerFactory.getLogger(TokenHelper.class);

    @Value("${security.jwt.secret}")
    private String jwtSecret;

    @Value("${security.jwt.expirationMs}")
    private int jwtExpirationMs;

    @Value("${security.jwt.rolePrefix}")
    private String rolePrefix;

    @Autowired
    JwtEncoder encoder;

    public TokenDTO gerarToken(String name, List<String> roles) throws UnsupportedEncodingException {
        Instant now = Instant.now();
        long expiry = jwtExpirationMs;

        String scope = roles.stream().collect(Collectors.joining(" "));

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry))
                .subject(name)
                .claim("scope", scope)
                .build();

        var token = this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return TokenDTO.builder()
                .accessToken(token)
                .tokenType("Bearer")
                .expiresIn(expiry).build();

    }

}
