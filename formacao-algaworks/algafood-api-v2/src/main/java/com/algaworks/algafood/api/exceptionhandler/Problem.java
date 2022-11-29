package com.algaworks.algafood.api.exceptionhandler;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Problem {

	private String mensagem;
	private LocalDateTime dataHora;
	
}
