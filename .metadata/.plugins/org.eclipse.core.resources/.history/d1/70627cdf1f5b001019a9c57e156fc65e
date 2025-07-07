package com.shetty.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shetty.ecommerce.Entities.User;
import com.shetty.ecommerce.dao.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User findUser(String email) {
		return userRepository.findByEmail(email);
	}
}
