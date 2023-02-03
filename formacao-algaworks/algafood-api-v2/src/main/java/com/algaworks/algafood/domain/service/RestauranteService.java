package com.algaworks.algafood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.RestauranteNaoEncontradoException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.model.Usuario;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Service
public class RestauranteService {

  private static final String MSG_RESTAURANTE_EM_USO = "Restaurante de código %d não pode ser removida, pois está em uso";

  @Autowired
  private RestauranteRepository restauranteRepository;

  @Autowired
  private CozinhaService cozinhaService;

  @Autowired
  private FormaPagamentoService formaPagamentoService;

  @Autowired
  private UsuarioService usuarioService;

  @Transactional
  public Restaurante salvar(Restaurante restaurante) {
    Long cozinhaId = restaurante.getCozinha().getId();

    Cozinha cozinha = cozinhaService.findOrFailure(cozinhaId);

    restaurante.setCozinha(cozinha);

    return restauranteRepository.save(restaurante);
  }

  @Transactional
  public void remover(Long restauranteId) {
    try {
      restauranteRepository.deleteById(restauranteId);
      restauranteRepository.flush();

    } catch (EmptyResultDataAccessException e) {
      throw new RestauranteNaoEncontradoException(restauranteId);

    } catch (DataIntegrityViolationException e) {
      throw new EntidadeEmUsoException(
          String.format(MSG_RESTAURANTE_EM_USO, restauranteId));
    }
  }

  @Transactional
  public void ativar(Long restauranteId) {
    Restaurante restauranteAtual = findOrFailure(restauranteId);
    restauranteAtual.ativar();
  }

  @Transactional
  public void ativar(List<Long> restauranteIds) {
    restauranteIds.forEach(this::ativar);
  }

  @Transactional
  public void desativar(Long restauranteId) {
    Restaurante restauranteAtual = findOrFailure(restauranteId);
    restauranteAtual.desativar();
  }

  @Transactional
  public void desativar(List<Long> restauranteIds) {
    restauranteIds.forEach(this::desativar);
  }

  @Transactional
  public void abrir(Long restauranteId) {
    Restaurante restauranteAtual = findOrFailure(restauranteId);
    restauranteAtual.abrir();
  }

  @Transactional
  public void fechar(Long restauranteId) {
    Restaurante restauranteAtual = findOrFailure(restauranteId);
    restauranteAtual.fechar();
  }

  @Transactional
  public void associarFormaPagamento(Long restauranteId, Long formaPagamentoId) {
    Restaurante restaurante = findOrFailure(restauranteId);
    FormaPagamento formaPagamento = formaPagamentoService.findOrFailure(formaPagamentoId);

    restaurante.adicionarFormaPagamento(formaPagamento);
  }

  @Transactional
  public void desassociarFormaPagamento(Long restauranteId, Long formaPagamentoId) {
    Restaurante restaurante = findOrFailure(restauranteId);
    FormaPagamento formaPagamento = formaPagamentoService.findOrFailure(formaPagamentoId);

    restaurante.removerFormaPagamento(formaPagamento);
  }

  @Transactional
  public void associarUsuario(Long restauranteId, Long UsuarioId) {
    Restaurante restaurante = findOrFailure(restauranteId);
    Usuario usuario = usuarioService.findOrFailure(UsuarioId);

    restaurante.adicionarUsuarioResponsavel(usuario);
  }

  @Transactional
  public void desassociarUsuario(Long restauranteId, Long usuarioId) {
    Restaurante restaurante = findOrFailure(restauranteId);
    Usuario usuario = usuarioService.findOrFailure(usuarioId);

    restaurante.removerUsuarioResponsavel(usuario);
  }

  public Restaurante findOrFailure(Long restauranteId) {
    return restauranteRepository.findById(restauranteId)
        .orElseThrow(() -> new RestauranteNaoEncontradoException(restauranteId));
  }

}
