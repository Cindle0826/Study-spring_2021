package com.study.spring.case03.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {
	public UserServiceimpl() {
		System.out.println("UserServiceimpl()");
	}

	@Override
	public void addUser(String name) {
		
		
	}
}
