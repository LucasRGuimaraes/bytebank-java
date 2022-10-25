package com.algaworks.algafood.di.notificacao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@Profile("development")
@TipoDoNotificador(NivelUrgencia.ALTA_PRIORIDADE)
@Component
public class NotificacaoEmailMock implements Notificador {
	
	public NotificacaoEmailMock() {
		System.out.println("Notificador email DOCK");
	}
	
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("MOCK: Notificação seria enviada para %s através do e-mail %s: %s\n", cliente.getNome(), cliente.getEmail(), mensagem);
	}

}
