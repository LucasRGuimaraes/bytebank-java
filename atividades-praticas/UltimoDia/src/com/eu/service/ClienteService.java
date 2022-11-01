package com.eu.service;

import com.eu.dao.ClienteDao;
import com.eu.dto.ClienteDTO;
import com.eu.pojos.Cliente;
import com.eu.pojos.ClienteBingen;
import com.eu.pojos.ClienteMais;

public class ClienteService {

	private ClienteDao clienteDao;

	public ClienteService() {
		clienteDao = new ClienteDao();
	}

	public void adicionaCliente(ClienteDTO clienteDTO) {
		Cliente clientePopulado = populaCliente(clienteDTO);
		clienteDao.salvaCliente(clientePopulado);
	}

	private Cliente populaCliente(ClienteDTO clienteDTO) {

		if (clienteDTO.getCpf() == null && clienteDTO.isVip() == false) {
			Cliente cliente = new Cliente();
			cliente.setNome(clienteDTO.getNome());
			cliente.setIdade(clienteDTO.getIdade());

			return cliente;

		} else if (clienteDTO.getCpf() != null) {
			ClienteMais clienteMais = new ClienteMais();
			clienteMais.setNome(clienteDTO.getNome());
			clienteMais.setIdade(clienteDTO.getIdade());
			clienteMais.setCpf(clienteDTO.getCpf());

			return clienteMais;

		} else {
			ClienteBingen clienteBingen = new ClienteBingen();
			clienteBingen.setNome(clienteDTO.getNome());
			clienteBingen.setIdade(clienteDTO.getIdade());
			clienteBingen.setVip(clienteDTO.isVip());

			return clienteBingen;
		}
	}

}
