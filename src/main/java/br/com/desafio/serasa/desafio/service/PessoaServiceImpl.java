package br.com.desafio.serasa.desafio.service;

import br.com.desafio.serasa.desafio.domain.entity.PessoaEntity;
import br.com.desafio.serasa.desafio.domain.interfaces.PessoaPerfilProjection;
import br.com.desafio.serasa.desafio.domain.interfaces.PessoaService;
import br.com.desafio.serasa.desafio.integracao.IBGEProxy;
import br.com.desafio.serasa.desafio.integracao.ViaCepProxy;
import br.com.desafio.serasa.desafio.repository.PessoaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService {

    private Logger logger = LoggerFactory.getLogger(PessoaServiceImpl.class);

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private ViaCepProxy cepClient;

    @Autowired
    private IBGEProxy ibgeProxy;

    public PessoaEntity create(PessoaEntity pessoa, String cep) {
        logger.info("Recuperando endereço por cep {}...", cep);
        var dadosEndereco = cepClient.getEnderecoPorCEP(cep);
        logger.info("Resultado: {}", dadosEndereco);

        logger.info("Recuperando dados do estado {}...", dadosEndereco.getUf());
        var estado = ibgeProxy.getEstadoPorSigla(dadosEndereco.getUf());
        logger.info("Resultado: {}", estado);

        pessoa.setCidade(dadosEndereco.getLocalidade().toLowerCase());
        pessoa.setEstado(dadosEndereco.getUf().toUpperCase());
        pessoa.setRegiao(estado.getRegiao().getNome().toLowerCase());
        return repository.save(pessoa);
    }

    public Optional<PessoaPerfilProjection> getById(Long id) {
        return Optional.ofNullable(repository.findOne(id));
    }

    public Page<PessoaPerfilProjection> list(Pageable pageable) {
        return repository.findPerfilWithPagination(pageable);
    }
    public void removeById(Long id) {
        repository.deleteById(id);
    }

}
