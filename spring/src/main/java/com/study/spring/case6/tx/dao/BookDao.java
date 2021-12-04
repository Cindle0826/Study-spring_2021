package com.study.spring.case6.tx.dao;

import com.study.spring.case6.tx.exception.InsufficientAmount;
import com.study.spring.case6.tx.exception.InsufficientQuantity;

public interface BookDao {
	Integer getPrice(Integer bid);
	Integer updateStock(Integer bid) throws InsufficientQuantity ;
	Integer updateWallet (Integer wid,Integer money) throws InsufficientAmount ; //扣掉金額
}
