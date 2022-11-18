package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.RestauranteNaoEncontradoException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Service
public class RestauranteService {
  
  private static final String MSG_RESTAURANTE_EM_USO = "Restaurante de código %d não pode ser removida, pois está em uso";

  @Autowired
  private RestauranteRepository restauranteRepository;

  @Autowired
  private CozinhaService cozinhaService;
  
  public Restaurante salvar(Restaurante restaurante) {
    Long cozinhaId = restaurante.getCozinha().getId();
    
    Cozinha cozinha = cozinhaService.findOrFailure(cozinhaId);
    
    restaurante.setCozinha(cozinha);

    return restauranteRepository.save(restaurante);
  }

  public void remover(Long restauranteId) {
    try {
      restauranteRepository.deleteById(restauranteId);

    } catch (EmptyResultDataAccessException e) {
      throw new RestauranteNaoEncontradoException(restauranteId);

    } catch (DataIntegrityViolationException e) {
      throw new EntidadeEmUsoException(
          String.format(MSG_RESTAURANTE_EM_USO, restauranteId));
    }
  }

  public Restaurante findOrFailure(Long restauranteId) {
    return restauranteRepository.findById(restauranteId)
        .orElseThrow(() -> new RestauranteNaoEncontradoException(restauranteId));
  }

}
