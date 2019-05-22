package com.kbsystems.finance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kbsystems.finance.domain.User;
import com.kbsystems.finance.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;

	public UserService(@Autowired UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	public User findByUsername() {
		return new User("Kylsonn","Abcd1234");
	}
	
	public User create(User user) {
		return this.userRepository.save(user);
	}
	
}
