package com.study.spring.case6.tx.exception;

public class InsufficientQuantity extends Throwable{
	public InsufficientQuantity() {
		super("Stock 書本庫存數量不足");
	}
}
