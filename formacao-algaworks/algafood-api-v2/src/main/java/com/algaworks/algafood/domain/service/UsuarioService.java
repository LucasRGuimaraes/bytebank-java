package com.algaworks.algafood.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.exception.UsuarioNaoEncontradoException;
import com.algaworks.algafood.domain.model.Grupo;
import com.algaworks.algafood.domain.model.Usuario;
import com.algaworks.algafood.domain.repository.UsuarioRepository;

@Service
public class UsuarioService {

  private static final String MSG_FORMA_PAGAMENTO_NAO_ENCONTRADA = "Não existe um cadastro de usuario com código %d";
  private static final String MSG_FORMA_PAGAMENTO_EM_USO = "Usuario de código %d não pode ser removida, pois está em uso";

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Autowired
  private GrupoService grupoService;

  @Transactional
  public Usuario salvar(Usuario usuario) {
    usuarioRepository.detach(usuario);

    Optional<Usuario> emailExistente = usuarioRepository.findByEmail(usuario.getEmail());

    if (emailExistente.isPresent() && !emailExistente.get().equals(usuario)) {
      throw new NegocioException(String.format("Já existe um usuário cadastrado com o e-mail %s", usuario.getEmail()));
    }

    return usuarioRepository.save(usuario);
  }

  @Transactional
  public void remover(Long usuarioId) {
    try {
      usuarioRepository.deleteById(usuarioId);
      usuarioRepository.flush();

    } catch (EmptyResultDataAccessException e) {
      throw new UsuarioNaoEncontradoException(
          String.format(MSG_FORMA_PAGAMENTO_NAO_ENCONTRADA, usuarioId));

    } catch (DataIntegrityViolationException e) {
      throw new EntidadeEmUsoException(
          String.format(MSG_FORMA_PAGAMENTO_EM_USO, usuarioId));
    }
  }

  @Transactional
  public void alterarSenha(Long usuarioId, String senhaAtual, String novaSenha) {
    Usuario usuario = findOrFailure(usuarioId);

    if (usuario.senhaNaoCoincideCom(senhaAtual)) {
      throw new NegocioException("Senha atual informada não coincide com a senha do usuário.");
    }

    usuario.setSenha(novaSenha);
  }

  @Transactional
  public void associarGrupo(Long usuarioId, Long grupoId) {
    Usuario usuario = findOrFailure(usuarioId);
    Grupo grupo = grupoService.findOrFailure(grupoId);

    usuario.adicionarGrupo(grupo);
  }

  @Transactional
  public void desassociarGrupo(Long usuarioId, Long grupoId) {
    Usuario usuario = findOrFailure(usuarioId);
    Grupo grupo = grupoService.findOrFailure(grupoId);

    usuario.removerGrupo(grupo);
  }

  public Usuario findOrFailure(Long usuarioId) {
    return usuarioRepository.findById(usuarioId)
        .orElseThrow(() -> new UsuarioNaoEncontradoException(
            String.format(MSG_FORMA_PAGAMENTO_NAO_ENCONTRADA, usuarioId)));
  }

}
