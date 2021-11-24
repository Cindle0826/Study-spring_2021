package com.study.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Author author = ctx.getBean("author",Author.class);
		Author author2 = (Author) ctx.getBean("author");
		System.out.println(author);
		System.out.println(author2);
	}
}
