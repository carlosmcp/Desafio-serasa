package br.com.desafio.serasa.desafio.service;

import br.com.desafio.serasa.desafio.domain.interfaces.AfinidadeService;
import br.com.desafio.serasa.desafio.fixtures.AfinidadeFixture;
import br.com.desafio.serasa.desafio.repository.AfinidadeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AfinidadeServiceTest {

    @InjectMocks
    private AfinidadeService service = new AfinidadeServiceImpl();

    @Mock
    private AfinidadeRepository repository;

    @Test
    public void deveCadastrarUmaAfinidade() throws Exception {
        when(repository.save(Mockito.any())).thenReturn(AfinidadeFixture.buildAfinidadeEntity());

        var result = service.create(AfinidadeFixture.buildAfinidadeEntity());
        assertNotNull(result);

        verify(repository).save(AfinidadeFixture.buildAfinidadeEntity());
        verify(repository, times(1)).save(Mockito.any());
    }
}
