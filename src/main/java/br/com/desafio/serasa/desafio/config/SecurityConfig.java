package br.com.desafio.serasa.desafio.config;

import br.com.desafio.serasa.desafio.domain.enums.RoleEnum;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
import org.springframework.security.oauth2.server.resource.web.access.BearerTokenAccessDeniedHandler;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Value("${security.jwt.public.key}")
    RSAPublicKey publicKey;

    @Value("${security.jwt.private.key}")
    RSAPrivateKey privateKey;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //H2 Console
        http.headers()
                .frameOptions().disable().and()
                .authorizeHttpRequests()
                .and().csrf().disable().cors()
                //Swagger
                .and().csrf().disable().cors().disable()
                .authorizeHttpRequests()
                .requestMatchers("/console/**").permitAll()
                .requestMatchers("/v3/api-docs").permitAll()
                .requestMatchers("/api-docs/**").permitAll()
                .requestMatchers("/swagger-ui/**").permitAll()
                .requestMatchers("/swagger-ui.html/**").permitAll()
                .requestMatchers("favicon.ico").permitAll()
                .requestMatchers("/javainuse-openapi/swagger-config/**").permitAll()
                .requestMatchers("/javainuse-openapi/**").permitAll()
                .requestMatchers("/webjars/**").permitAll()
                //Login
                .requestMatchers("/logon/**").permitAll()
                //Rotas
                .requestMatchers("/afinidade/**").hasAnyAuthority("SCOPE_ADMIN", "SCOPE_USER")
                .requestMatchers("/score/**").hasAnyAuthority("SCOPE_ADMIN", "SCOPE_USER")
                .requestMatchers(HttpMethod.GET, "/pessoa/**").hasAnyAuthority("SCOPE_ADMIN", "SCOPE_USER")
                .requestMatchers(HttpMethod.POST, "/pessoa/**").hasAnyAuthority("SCOPE_ADMIN", "SCOPE_USER")
                .requestMatchers(HttpMethod.DELETE, "/pessoa/**").hasAuthority("SCOPE_ADMIN")
                .and()
                .httpBasic(Customizer.withDefaults())
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling((exceptions) -> exceptions
                        .authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint())
                        .accessDeniedHandler(new BearerTokenAccessDeniedHandler()));

        return http.build();
    }


    @Bean
    UserDetailsService users() {
        return new InMemoryUserDetailsManager(
                User.withUsername("admin@teste.com")
                        .password("{noop}123456")
                        .authorities(RoleEnum.ADMIN.name())
                        .build()
                ,
                User.withUsername("user@teste.com")
                        .password("{noop}123456")
                        .authorities(RoleEnum.USER.name())
                        .build()
        );
    }

    @Bean
    JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey(this.publicKey).build();
    }

    @Bean
    JwtEncoder jwtEncoder() {
        JWK jwk = new RSAKey.Builder(this.publicKey).privateKey(this.privateKey).build();
        JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
        return new NimbusJwtEncoder(jwks);
    }


}