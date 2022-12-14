package br.com.desafio.serasa.desafio.controller;

import br.com.desafio.serasa.desafio.util.TestUtil;
import br.com.desafio.serasa.desafio.domain.enums.RoleEnum;
import br.com.desafio.serasa.desafio.domain.interfaces.ScoreService;
import br.com.desafio.serasa.desafio.fixtures.ScoreFixture;
import br.com.desafio.serasa.desafio.util.TokenHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class ScoreControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    private String accessToken;

    @Autowired
    private TokenHelper tokenHelper;

    @MockBean
    private ScoreService service;

    @BeforeEach
    public void setup() throws UnsupportedEncodingException {

        var token = tokenHelper.gerarToken("user@teste.com", List.of(RoleEnum.USER.name()));
        this.accessToken = token.getAccessToken();

        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void deveCadastrarUmScore() throws Exception {
        String expectResult = "{'scoreDescricao':'Recomendável','inicial':701,'final':1000}";

        when(service.create(Mockito.any())).thenReturn(ScoreFixture.buildEntity());

        this.mockMvc.perform( post("/score")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.toJson(ScoreFixture.buildEntityDTO()))
                        .with(mockRequest -> {
                            mockRequest.addHeader("Authorization", "Bearer " + accessToken);
                            return mockRequest;
                        })
                )
                .andDo(print()).andExpect(status().isCreated())
                .andExpect(content().json(expectResult));
    }

}
