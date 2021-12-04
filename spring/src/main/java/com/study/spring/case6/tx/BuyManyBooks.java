package com.study.spring.case6.tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.study.spring.case6.tx.controller.BookController;

public class BuyManyBooks {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		BookController bookController = (BookController) ctx.getBean("bookControllerImpl");
		int wid = 1, bid = 1;
		bookController.buyBooks(wid, bid, bid);

	}
}
