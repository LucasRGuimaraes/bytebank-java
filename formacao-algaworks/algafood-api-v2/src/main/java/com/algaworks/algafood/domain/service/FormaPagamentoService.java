package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.exception.FormaPagamentoNaoEncontradaException;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

@Service
public class FormaPagamentoService {

  private static final String MSG_FORMA_PAGAMENTO_NAO_ENCONTRADA = "Não existe um cadastro de formaPagamento com código %d";
  private static final String MSG_FORMA_PAGAMENTO_EM_USO = "FormaPagamento de código %d não pode ser removida, pois está em uso";

  @Autowired
  private FormaPagamentoRepository formaPagamentoRepository;

  @Transactional
  public FormaPagamento salvar(FormaPagamento formaPagamento) {
    return formaPagamentoRepository.save(formaPagamento);
  }

  @Transactional
  public void remover(Long formaPagamentoId) {
    try {
      formaPagamentoRepository.deleteById(formaPagamentoId);
      formaPagamentoRepository.flush();

    } catch (EmptyResultDataAccessException e) {
      throw new FormaPagamentoNaoEncontradaException(
          String.format(MSG_FORMA_PAGAMENTO_NAO_ENCONTRADA, formaPagamentoId));

    } catch (DataIntegrityViolationException e) {
      throw new EntidadeEmUsoException(
          String.format(MSG_FORMA_PAGAMENTO_EM_USO, formaPagamentoId));
    }
  }

  public FormaPagamento findOrFailure(Long formaPagamentoId) {
    return formaPagamentoRepository.findById(formaPagamentoId)
        .orElseThrow(() -> new FormaPagamentoNaoEncontradaException(
            String.format(MSG_FORMA_PAGAMENTO_NAO_ENCONTRADA, formaPagamentoId)));
  }

}
