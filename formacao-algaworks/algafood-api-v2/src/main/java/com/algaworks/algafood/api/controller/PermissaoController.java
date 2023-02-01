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

import com.algaworks.algafood.api.assembler.PermissaoDTOAssembler;
import com.algaworks.algafood.api.assembler.disassembler.PermissaoInputDisassembler;
import com.algaworks.algafood.api.model.dto.PermissaoDTO;
import com.algaworks.algafood.api.model.input.PermissaoInput;
import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.repository.PermissaoRepository;
import com.algaworks.algafood.domain.service.PermissaoService;

@RestController
@RequestMapping("/permissoes")
public class PermissaoController {

  @Autowired
  private PermissaoRepository permissaoRepository;

  @Autowired
  private PermissaoService permissaoService;

  @Autowired
  private PermissaoDTOAssembler permissaoDTOAssembler;

  @Autowired
  private PermissaoInputDisassembler permissaoInputDisassembler;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<PermissaoDTO> listar() {
    return permissaoDTOAssembler.toCollectionDTO(permissaoRepository.findAll());
  }

  @GetMapping("/{permissaoId}")
  public PermissaoDTO buscar(@PathVariable Long permissaoId) {
    return permissaoDTOAssembler.toDTO(permissaoService.findOrFailure(permissaoId));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PermissaoDTO adicionar(@RequestBody @Valid PermissaoInput permissaoInput) {
    Permissao permissao = permissaoInputDisassembler.toDomainObject(permissaoInput);
    return permissaoDTOAssembler.toDTO(permissaoService.salvar(permissao));
  }

  @PutMapping("/{permissaoId}")
  public PermissaoDTO atualizar(@PathVariable Long permissaoId, @RequestBody PermissaoInput permissaoInput) {
    Permissao permissaoAtual = permissaoService.findOrFailure(permissaoId);
    permissaoInputDisassembler.copyToDomainObject(permissaoInput, permissaoAtual);

    return permissaoDTOAssembler.toDTO(permissaoService.salvar(permissaoAtual));
  }

  @DeleteMapping("/{permissaoId}")
  public void remover(@PathVariable Long permissaoId) {
    permissaoService.remover(permissaoId);
  }

}
