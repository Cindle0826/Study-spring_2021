package com.study.spring.case6.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.study.spring.case6.tx.dao.BookDao;
import com.study.spring.case6.tx.exception.InsufficientAmount;
import com.study.spring.case6.tx.exception.InsufficientQuantity;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	@Transactional(
			rollbackFor =  {InsufficientQuantity.class,InsufficientAmount.class}

	)

	@Override
	public void buyOne(Integer wid, Integer bid) throws InsufficientAmount, InsufficientQuantity {
		int price = bookDao.getPrice(bid);
		bookDao.updateStock(bid); // 減去庫存

		// 製造一個商業邏輯的錯誤
//		System.out.println(10/0);
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		bookDao.updateWallet(wid, price); // 錢包減去的金額
	}


	@Override
	public void buyMany(Integer wid, Integer... bids) throws InsufficientAmount, InsufficientQuantity {
		for (int bid : bids) {
			buyOne(wid, bid);
		}
	}
}
