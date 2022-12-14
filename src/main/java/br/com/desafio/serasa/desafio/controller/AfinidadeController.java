package br.com.desafio.serasa.desafio.controller;

import br.com.desafio.serasa.desafio.domain.dto.AfinidadeDTO;
import br.com.desafio.serasa.desafio.domain.interfaces.AfinidadeService;
import br.com.desafio.serasa.desafio.mapper.AfinidadeMapper;
import br.com.desafio.serasa.desafio.service.AfinidadeServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("afinidade")
public class AfinidadeController {

    @Autowired
    private AfinidadeService service;

    private AfinidadeMapper MAPPER = Mappers.getMapper(AfinidadeMapper.class);

    @PostMapping
    @Operation(summary = "Cria uma afinidade")
    @ResponseStatus(HttpStatus.CREATED)
    public AfinidadeDTO create(@Valid @RequestBody AfinidadeDTO dto) {
        return MAPPER.toDTO(service.create(MAPPER.toEntity(dto)));
    }

    @GetMapping(value = "")
    @Operation(summary = "Lista todas as afinidades")
    public List<AfinidadeDTO> list() {
        return service.list().stream().map(MAPPER::toDTO).collect(Collectors.toList());
    }
}
