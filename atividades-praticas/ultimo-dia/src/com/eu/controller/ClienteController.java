package com.eu.controller;

import com.eu.dto.ClienteDTO;
import com.eu.pojos.ClienteBingen;
import com.eu.pojos.ClienteMais;
import com.eu.service.ClienteService;

public class ClienteController {
	
	
	public void criaCliente(String dadosAqui) {
		
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setNome(dadosAqui);
		clienteDTO.setIdade(0);
		clienteDTO.setCpf(dadosAqui);
		clienteDTO.setVip(true);
		
		ClienteService clienteService = new ClienteService();
		clienteService.adicionaCliente(clienteDTO);
		
		
	}
}
