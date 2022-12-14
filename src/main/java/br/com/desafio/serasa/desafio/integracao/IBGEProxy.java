package br.com.desafio.serasa.desafio.integracao;

import br.com.desafio.serasa.desafio.config.ClientConfiguration;
import br.com.desafio.serasa.desafio.domain.dto.EstadoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ibge", url = "${endpoints.ibge}", configuration = ClientConfiguration.class)
public interface IBGEProxy {

    @GetMapping(value = "/{uf}/")
    EstadoDTO getEstadoPorSigla(@PathVariable("uf") String uf);
}
