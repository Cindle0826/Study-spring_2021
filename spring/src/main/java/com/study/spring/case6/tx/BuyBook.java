package com.study.spring.case6.tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.study.spring.case6.tx.controller.BookController;

public class BuyBook {
	public static void main(String[] args) {
		// [{bid=1, bname=Java, price=80, ct=2021-12-03 01:49:45.0}]
		// [{sid=1, bid=1, amount=3}]
		// [{wid=1, money=100}]

		// wallet 1 要買 book 1

		// 執行 Book Controller(1,1);
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		BookController bookController = (BookController) ctx.getBean("bookControllerImpl");
		int wid = 1, bid = 1;
		bookController.buyBook(wid, bid);

	}
}
