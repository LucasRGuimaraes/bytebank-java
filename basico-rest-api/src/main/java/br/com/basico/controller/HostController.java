package br.com.basico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.basico.model.Host;
import br.com.basico.repository.HostRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/hosts")
public class HostController {
	
	@Autowired
	private HostRepository hostRepository;
	
	@GetMapping
	public List<Host> listar() {
		return hostRepository.findAll();
	}

	@PostMapping
	public Host adicionar(@RequestBody Host host) {
		return hostRepository.save(host);
	}
	
}
