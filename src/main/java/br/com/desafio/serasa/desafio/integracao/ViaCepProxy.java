package br.com.desafio.serasa.desafio.integracao;

import br.com.desafio.serasa.desafio.config.ClientConfiguration;
import br.com.desafio.serasa.desafio.domain.dto.EnderecoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "${endpoints.viacep}", configuration = ClientConfiguration.class)
public interface ViaCepProxy {

    @GetMapping(value = "/{cep}/json")
    EnderecoDTO getEnderecoPorCEP(@PathVariable("cep") String cep);

}
