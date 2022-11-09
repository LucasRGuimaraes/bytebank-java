package br.com.basico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.basico.model.Pessoa;
import br.com.basico.repository.BasicoRepository;

@RestController
@RequestMapping("/basico")
public class basicoController {
	
	@Autowired
	private BasicoRepository basicoRepository;
	
	@GetMapping
	public List<Pessoa> listar() {
		return basicoRepository.findAll();
	}
	
}
