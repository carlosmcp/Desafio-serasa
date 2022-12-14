package br.com.desafio.serasa.desafio.service;

import br.com.desafio.serasa.desafio.domain.interfaces.PessoaService;
import br.com.desafio.serasa.desafio.fixtures.PessoaFixture;
import br.com.desafio.serasa.desafio.integracao.IBGEProxy;
import br.com.desafio.serasa.desafio.integracao.ViaCepProxy;
import br.com.desafio.serasa.desafio.repository.PessoaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PessoaServiceTest {
    @InjectMocks
    private PessoaService service = new PessoaServiceImpl();

    @Mock
    private PessoaRepository repository;

    @Mock
    private ViaCepProxy viaCepProxy;

    @Mock
    private IBGEProxy ibgeProxy;

    @Test
    public void deveCadastrarUmaAfinidade() throws Exception {
        when(repository.save(Mockito.any())).thenReturn(PessoaFixture.buildEntity());
        when(viaCepProxy.getEnderecoPorCEP(Mockito.any())).thenReturn(PessoaFixture.buildEnderecoDTO());
        when(ibgeProxy.getEstadoPorSigla(Mockito.any())).thenReturn(PessoaFixture.buildEstadoDTO());

        var result = service.create(PessoaFixture.buildEntity(), "68906844");

        assertNotNull(result);
        verify(repository).save(PessoaFixture.buildEntity());
        verify(repository, times(1)).save(Mockito.any());
    }

}
