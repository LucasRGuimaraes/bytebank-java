package com.example.domain.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.domain.entities.User;

/**
 * 
 * @author Thiago Guimarãesss
 * @date 16/12/2022 20:30:53
 */
public class UserRepository {

	private List<User> userList = new ArrayList<>();
	private static UserRepository instace_;
	
	private UserRepository() {}
	
	public static UserRepository getInstace_() {
		
		if(instace_ == null) {
			instace_ = new UserRepository();
		}
		
		return instace_;
	}

	
	public List<User> getUserList() {
		return userList;
	}
	
	public void addUser(User user) {
		userList.add(user);
	}
}
