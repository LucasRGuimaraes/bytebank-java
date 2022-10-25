package com.algaworks.algafood.di.notificacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@TipoDoNotificador(NivelUrgencia.BAIXA_PRIORIDADE)
@Component
public class NotificacaoSMS implements Notificador {
	
	@Autowired
	private NotificadorProperties properties;
	
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.println("Host: " + properties.getHostServidor());
		System.out.println("Porta: " + properties.getPortaServidor());
		System.out.printf("Notificando %s por SMS através do telefone %s: %s\n", cliente.getNome(), cliente.getTelefone(), mensagem);
	}

}
