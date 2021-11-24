package com.study.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Author author1 = (Author) ctx.getBean("author");
		System.out.println(author1);
		
		Author author2 = (Author) ctx.getBean("author2");
		System.out.println(author2);
	}
}
