package br.com.teste;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/host")
public class HostController {
	
	@Autowired
	private HostRepository hostRepository;
	
	@GetMapping
	public List<Host> listar() {
		return hostRepository.findAll();
	}
	
}
