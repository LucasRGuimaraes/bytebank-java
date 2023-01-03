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

import com.algaworks.algafood.api.assembler.EstadoDTOAssembler;
import com.algaworks.algafood.api.assembler.disassembler.EstadoInputDisassembler;
import com.algaworks.algafood.api.model.dto.EstadoDTO;
import com.algaworks.algafood.api.model.input.EstadoInput;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import com.algaworks.algafood.domain.service.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController {

  @Autowired
  private EstadoRepository estadoRepository;

  @Autowired
  private EstadoService estadoService;

  @Autowired
  private EstadoDTOAssembler estadoDTOAssembler;

  @Autowired
  private EstadoInputDisassembler estadoInputDisassembler;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<EstadoDTO> listar() {
    return estadoDTOAssembler.toCollectionDTO(estadoRepository.findAll());
  }

  @GetMapping("/{estadoId}")
  public EstadoDTO buscar(@PathVariable Long estadoId) {
    return estadoDTOAssembler.toDTO(estadoService.findOrFailure(estadoId));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public EstadoDTO adicionar(@RequestBody @Valid EstadoInput estadoInput) {
    Estado estado = estadoInputDisassembler.toDomainObject(estadoInput);
    return estadoDTOAssembler.toDTO(estadoService.salvar(estado));
  }

  @PutMapping("/{estadoId}")
  public EstadoDTO atualizar(@PathVariable Long estadoId, @RequestBody EstadoInput estadoInput) {
    Estado estadoAtual = estadoService.findOrFailure(estadoId);
    estadoInputDisassembler.copyToDomainObject(estadoInput, estadoAtual);

    return estadoDTOAssembler.toDTO(estadoService.salvar(estadoAtual));
  }

  @DeleteMapping("/{estadoId}")
  public void remover(@PathVariable Long estadoId) {
    estadoService.remover(estadoId);
  }

}
