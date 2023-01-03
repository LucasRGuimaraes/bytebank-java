package com.algaworks.algafood.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.assembler.CozinhaDTOAssembler;
import com.algaworks.algafood.api.assembler.disassembler.CozinhaInputDisassembler;
import com.algaworks.algafood.api.model.dto.CozinhaDTO;
import com.algaworks.algafood.api.model.input.CozinhaInput;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.service.CozinhaService;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

  @Autowired
  private CozinhaRepository cozinhaRepository;

  @Autowired
  private CozinhaService cozinhaService;

  @Autowired
  private CozinhaDTOAssembler cozinhaDTOAssembler;

  @Autowired
  private CozinhaInputDisassembler cozinhaInputDisassembler;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<CozinhaDTO> listar() {
    return cozinhaDTOAssembler.toCollectionDTO(cozinhaRepository.findAll());
  }

  @GetMapping("/{cozinhaId}")
  public CozinhaDTO buscar(@PathVariable Long cozinhaId) {
    return cozinhaDTOAssembler.toDTO(cozinhaService.findOrFailure(cozinhaId));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CozinhaDTO adicionar(@RequestBody @Valid CozinhaInput cozinhaInput) {
    Cozinha cozinha = cozinhaInputDisassembler.toDomainObject(cozinhaInput);
    return cozinhaDTOAssembler.toDTO(cozinhaService.salvar(cozinha));
  }

  @PutMapping("/{cozinhaId}")
  public CozinhaDTO atualizar(@PathVariable Long cozinhaId, @RequestBody CozinhaInput cozinhaInput) {
    Cozinha cozinhaAtual = cozinhaService.findOrFailure(cozinhaId);
    cozinhaInputDisassembler.copyToDomainObject(cozinhaInput, cozinhaAtual);

    return cozinhaDTOAssembler.toDTO(cozinhaService.salvar(cozinhaAtual));
  }

  @DeleteMapping("/{cozinhaId}")
  public void remover(@PathVariable Long cozinhaId) {
    cozinhaService.remover(cozinhaId);
  }

}
