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

import com.algaworks.algafood.api.assembler.UsuarioDTOAssembler;
import com.algaworks.algafood.api.assembler.disassembler.UsuarioInputDisassembler;
import com.algaworks.algafood.api.model.dto.UsuarioDTO;
import com.algaworks.algafood.api.model.input.SenhaInput;
import com.algaworks.algafood.api.model.input.UsuarioComSenhaInput;
import com.algaworks.algafood.api.model.input.UsuarioInput;
import com.algaworks.algafood.domain.model.Usuario;
import com.algaworks.algafood.domain.repository.UsuarioRepository;
import com.algaworks.algafood.domain.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Autowired
  private UsuarioService usuarioService;

  @Autowired
  private UsuarioDTOAssembler usuarioDTOAssembler;

  @Autowired
  private UsuarioInputDisassembler usuarioInputDisassembler;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<UsuarioDTO> listar() {
    return usuarioDTOAssembler.toCollectionDTO(usuarioRepository.findAll());
  }

  @GetMapping("/{usuarioId}")
  public UsuarioDTO buscar(@PathVariable Long usuarioId) {
    return usuarioDTOAssembler.toDTO(usuarioService.findOrFailure(usuarioId));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public UsuarioDTO adicionar(@RequestBody @Valid UsuarioComSenhaInput usuarioInput) {
    Usuario usuario = usuarioInputDisassembler.toDomainObject(usuarioInput);
    return usuarioDTOAssembler.toDTO(usuarioService.salvar(usuario));
  }

  @PutMapping("/{usuarioId}")
  public UsuarioDTO atualizar(@PathVariable Long usuarioId, @RequestBody UsuarioInput usuarioInput) {
    Usuario usuarioAtual = usuarioService.findOrFailure(usuarioId);
    usuarioInputDisassembler.copyToDomainObject(usuarioInput, usuarioAtual);

    return usuarioDTOAssembler.toDTO(usuarioService.salvar(usuarioAtual));
  }

  @PutMapping("/{usuarioId}/senha")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void alterarSenha(@PathVariable Long usuarioId, @RequestBody @Valid SenhaInput senha) {
    usuarioService.alterarSenha(usuarioId, senha.getSenhaAtual(), senha.getNovaSenha());
  }

  @DeleteMapping("/{usuarioId}")
  public void remover(@PathVariable Long usuarioId) {
    usuarioService.remover(usuarioId);
  }

}
