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

		Author author3 = (Author) ctx.getBean("author3");
		System.out.println(author3);
		
		Author author4 = (Author) ctx.getBean("author4");
		System.out.println(author4);
		
		Book book1=(Book) ctx.getBean("book1");
		System.out.println(book1);
		Book book2=(Book) ctx.getBean("book2");
		System.out.println(book2);
	}
}
