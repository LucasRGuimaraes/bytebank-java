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

import com.algaworks.algafood.api.assembler.GrupoDTOAssembler;
import com.algaworks.algafood.api.assembler.disassembler.GrupoInputDisassembler;
import com.algaworks.algafood.api.model.dto.GrupoDTO;
import com.algaworks.algafood.api.model.input.GrupoInput;
import com.algaworks.algafood.domain.model.Grupo;
import com.algaworks.algafood.domain.repository.GrupoRepository;
import com.algaworks.algafood.domain.service.GrupoService;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

  @Autowired
  private GrupoRepository grupoRepository;

  @Autowired
  private GrupoService grupoService;

  @Autowired
  private GrupoDTOAssembler grupoDTOAssembler;

  @Autowired
  private GrupoInputDisassembler grupoInputDisassembler;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<GrupoDTO> listar() {
    return grupoDTOAssembler.toCollectionDTO(grupoRepository.findAll());
  }

  @GetMapping("/{grupoId}")
  public GrupoDTO buscar(@PathVariable Long grupoId) {
    return grupoDTOAssembler.toDTO(grupoService.findOrFailure(grupoId));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public GrupoDTO adicionar(@RequestBody @Valid GrupoInput grupoInput) {
    Grupo grupo = grupoInputDisassembler.toDomainObject(grupoInput);
    return grupoDTOAssembler.toDTO(grupoService.salvar(grupo));
  }

  @PutMapping("/{grupoId}")
  public GrupoDTO atualizar(@PathVariable Long grupoId, @RequestBody GrupoInput grupoInput) {
    Grupo grupoAtual = grupoService.findOrFailure(grupoId);
    grupoInputDisassembler.copyToDomainObject(grupoInput, grupoAtual);

    return grupoDTOAssembler.toDTO(grupoService.salvar(grupoAtual));
  }

  @DeleteMapping("/{grupoId}")
  public void remover(@PathVariable Long grupoId) {
    grupoService.remover(grupoId);
  }

}
