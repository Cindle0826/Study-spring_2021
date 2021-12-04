package com.study.spring.case6.tx.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.study.spring.case6.tx.exception.InsufficientAmount;
import com.study.spring.case6.tx.exception.InsufficientQuantity;
import com.study.spring.case6.tx.service.BookService;

@Controller
public class BookControllerImpl implements BookController{
	@Autowired
	private BookService bookService;
	@Override
	public void buyBook(Integer wid, Integer bid) {
		try {
			bookService.buyOne(wid, bid);
			System.out.println("buyBook ok");
			
			
		} catch ( InsufficientAmount | InsufficientQuantity e) {
			System.out.println(e);
		}
	}

	@Override
	public void buyBooks(Integer wid, Integer... bids) {
		try {
			bookService.buyMany(wid, bids);
			System.out.println("Buy ManyBooks ok");
			
		} catch (InsufficientAmount | InsufficientQuantity e) {
			System.out.println(e);
		}
		
	}
	
}
