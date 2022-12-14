package br.com.desafio.serasa.desafio.service;

import br.com.desafio.serasa.desafio.domain.interfaces.ScoreService;
import br.com.desafio.serasa.desafio.fixtures.ScoreFixture;
import br.com.desafio.serasa.desafio.repository.ScoreRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ScoreServiceTest {
    @InjectMocks
    private ScoreService service = new ScoreServiceImpl();

    @Mock
    private ScoreRepository repository;

    @Test
    public void deveCadastrarUmaAfinidade() throws Exception {
        when(repository.save(Mockito.any())).thenReturn(ScoreFixture.buildEntity());

        var result = service.create(ScoreFixture.buildEntity());
        assertNotNull(result);

        verify(repository).save(ScoreFixture.buildEntity());
        verify(repository, times(1)).save(Mockito.any());
    }
}
