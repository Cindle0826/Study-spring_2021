package com.study.spring.case03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.case03.model.Page;
import com.study.spring.case03.model.User;

public class UserTest2 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext3.xml");
		User user = (User) ctx.getBean("user");
		System.out.println(user);
	
		Page p = (Page) ctx.getBean("page");
		System.out.println(p);
	}
}