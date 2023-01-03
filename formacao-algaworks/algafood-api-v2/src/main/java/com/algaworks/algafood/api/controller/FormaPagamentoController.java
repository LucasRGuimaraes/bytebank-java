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

import com.algaworks.algafood.api.assembler.FormaPagamentoDTOAssembler;
import com.algaworks.algafood.api.assembler.disassembler.FormaPagamentoInputDisassembler;
import com.algaworks.algafood.api.model.dto.FormaPagamentoDTO;
import com.algaworks.algafood.api.model.input.FormaPagamentoInput;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;
import com.algaworks.algafood.domain.service.FormaPagamentoService;

@RestController
@RequestMapping("/formaPagamentos")
public class FormaPagamentoController {

  @Autowired
  private FormaPagamentoRepository formaPagamentoRepository;

  @Autowired
  private FormaPagamentoService formaPagamentoService;

  @Autowired
  private FormaPagamentoDTOAssembler formaPagamentoDTOAssembler;

  @Autowired
  private FormaPagamentoInputDisassembler formaPagamentoInputDisassembler;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<FormaPagamentoDTO> listar() {
    return formaPagamentoDTOAssembler.toCollectionDTO(formaPagamentoRepository.findAll());
  }

  @GetMapping("/{formaPagamentoId}")
  public FormaPagamentoDTO buscar(@PathVariable Long formaPagamentoId) {
    return formaPagamentoDTOAssembler.toDTO(formaPagamentoService.findOrFailure(formaPagamentoId));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public FormaPagamentoDTO adicionar(@RequestBody @Valid FormaPagamentoInput formaPagamentoInput) {
    FormaPagamento formaPagamento = formaPagamentoInputDisassembler.toDomainObject(formaPagamentoInput);
    return formaPagamentoDTOAssembler.toDTO(formaPagamentoService.salvar(formaPagamento));
  }

  @PutMapping("/{formaPagamentoId}")
  public FormaPagamentoDTO atualizar(@PathVariable Long formaPagamentoId, @RequestBody FormaPagamentoInput formaPagamentoInput) {
    FormaPagamento formaPagamentoAtual = formaPagamentoService.findOrFailure(formaPagamentoId);
    formaPagamentoInputDisassembler.copyToDomainObject(formaPagamentoInput, formaPagamentoAtual);

    return formaPagamentoDTOAssembler.toDTO(formaPagamentoService.salvar(formaPagamentoAtual));
  }

  @DeleteMapping("/{formaPagamentoId}")
  public void remover(@PathVariable Long formaPagamentoId) {
    formaPagamentoService.remover(formaPagamentoId);
  }

}
