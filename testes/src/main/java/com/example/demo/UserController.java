package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.domain.entities.User;
import com.example.domain.repository.UserRepository;

@RestController
@RequestMapping("users")
public class UserController {
	
	private UserRepository userRepository =  UserRepository.getInstace_();
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> listUsers(){
		return userRepository.getUserList();
	}
	
	@PostMapping
	public void saveUser(@RequestBody User user) {
		userRepository.addUser(user);
	}
	
	@PostMapping("excel")
	public void saveUser(@RequestBody MultipartFile file) {
		userService.analisarArquivo(file);
	}

}
