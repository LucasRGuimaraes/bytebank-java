package br.com.restaurante.exceptions;

import br.com.restaurante.modelo.SalgadoFrito;

public class ServiceException extends Exception {

	public ServiceException(String msg) {
		super(msg);
	}
}
