package br.com.desafio.serasa.desafio.controller;

import br.com.desafio.serasa.desafio.domain.dto.PessoaDTO;
import br.com.desafio.serasa.desafio.domain.interfaces.PessoaPerfilProjection;
import br.com.desafio.serasa.desafio.domain.interfaces.PessoaService;
import br.com.desafio.serasa.desafio.mapper.PessoaMapper;
import br.com.desafio.serasa.desafio.mapper.PessoaPerfilMapper;
import br.com.desafio.serasa.desafio.service.PessoaServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

    @Autowired
    private PessoaService service;

    private PessoaMapper MAPPER = Mappers.getMapper(PessoaMapper.class);

    private PessoaPerfilMapper MAPPER_PERFIL = Mappers.getMapper(PessoaPerfilMapper.class);

    @Operation(summary = "Cria uma pessoa")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaDTO create(@Valid @RequestBody PessoaDTO dto) {
        return MAPPER.toDTO(service.create(MAPPER.toEntity(dto), dto.getCep()));
    }

    @Operation(summary = "Recupera uma pessoa por ID")
    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaPerfilProjection> getById(@PathVariable("id") Long id) {
        return service.getById(id).map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Remove uma pessoa por ID")
    @DeleteMapping(value = "/{id}")
    public void removeById(@PathVariable("id") Long id) {
        service.removeById(id);
    }

    @Operation(summary = "Lista de pessoas")
    @GetMapping(value = "")
    public Page<PessoaPerfilProjection> list(Pageable p) {
        return service.list(p);
    }


}
