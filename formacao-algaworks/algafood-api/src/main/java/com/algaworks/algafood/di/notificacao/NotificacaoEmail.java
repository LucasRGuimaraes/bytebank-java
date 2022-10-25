package com.algaworks.algafood.di.notificacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@Profile("production")
@TipoDoNotificador(NivelUrgencia.ALTA_PRIORIDADE)
@Component
public class NotificacaoEmail implements Notificador {
	
	@Autowired
	private NotificadorProperties properties;

	public NotificacaoEmail() {
		System.out.println("Notificador email REAL");
	}
	
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("Notificando %s através do e-mail %s: %s\n", cliente.getNome(), cliente.getEmail(), mensagem);
		System.out.println("Host: " + properties.getHostServidor());
		System.out.println("Porta: " + properties.getPortaServidor());
	}

}
