package com.study.spring.case03.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.spring.case03.dao.UserDao;


@Service
public class UserServiceimpl implements UserService {
//	private UserDao userDao = new UserDaoImpl();
	@Autowired
	private UserDao userDao;

	public UserServiceimpl() {
		System.out.println("UserServiceimpl()");
	}

	@Override
	public void addUser() {
		userDao.createUser();

	}
}
