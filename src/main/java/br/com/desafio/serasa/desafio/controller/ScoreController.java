package br.com.desafio.serasa.desafio.controller;

import br.com.desafio.serasa.desafio.domain.dto.ScoreDTO;
import br.com.desafio.serasa.desafio.domain.interfaces.ScoreService;
import br.com.desafio.serasa.desafio.mapper.ScoreMapper;
import br.com.desafio.serasa.desafio.service.ScoreServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("score")
public class ScoreController {

    @Autowired
    private ScoreService service;

    private ScoreMapper MAPPER = Mappers.getMapper(ScoreMapper.class);

    @PostMapping
    @Operation(summary = "Cadastra um Score")
    @ResponseStatus(HttpStatus.CREATED)
    public ScoreDTO create(@RequestBody ScoreDTO dto) {
        return MAPPER.toDTO(service.create(MAPPER.toEntity(dto)));
    }

    @GetMapping(value = "")
    @Operation(summary = "Lista todos os Scores")
    public List<ScoreDTO> list() {
        return service.list().stream().map(MAPPER::toDTO).collect(Collectors.toList());
    }
}
