package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hosts")
public class HostController {
	
	@GetMapping
	public String get() {
		return "Ola";
	}

}
