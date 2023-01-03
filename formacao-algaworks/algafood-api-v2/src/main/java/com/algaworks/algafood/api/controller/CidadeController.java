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

import com.algaworks.algafood.api.assembler.CidadeDTOAssembler;
import com.algaworks.algafood.api.assembler.disassembler.CidadeInputDisassembler;
import com.algaworks.algafood.api.model.dto.CidadeDTO;
import com.algaworks.algafood.api.model.input.CidadeInput;
import com.algaworks.algafood.domain.exception.EstadoNaoEncontradoException;
import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.service.CidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private CidadeService cidadeService;

	@Autowired
	private CidadeDTOAssembler cidadeDTOAssembler;

	@Autowired
	private CidadeInputDisassembler cidadeInputDisassembler;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CidadeDTO> listar() {
		return cidadeDTOAssembler.toCollectionDTO(cidadeRepository.findAll());
	}

	@GetMapping("/{cidadeId}")
	public CidadeDTO buscar(@PathVariable Long cidadeId) {
		return cidadeDTOAssembler.toDTO(cidadeService.findOrFailure(cidadeId));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CidadeDTO adicionar(@RequestBody @Valid CidadeInput cidadeInput) {
		try {
			Cidade cidade = cidadeInputDisassembler.toDomainObject(cidadeInput);
			return cidadeDTOAssembler.toDTO(cidadeService.salvar(cidade));
		} catch (EstadoNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@PutMapping("/{cidadeId}")
	public CidadeDTO atualizar(@PathVariable Long cidadeId, @RequestBody CidadeInput cidadeInput) {
		try {
			Cidade cidadeAtual = cidadeService.findOrFailure(cidadeId);
			cidadeInputDisassembler.copyToDomainObject(cidadeInput, cidadeAtual);

			return cidadeDTOAssembler.toDTO(cidadeService.salvar(cidadeAtual));
		} catch (EstadoNaoEncontradoException e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}

	@DeleteMapping("/{cidadeId}")
	public void remover(@PathVariable Long cidadeId) {
		cidadeService.remover(cidadeId);
	}

}