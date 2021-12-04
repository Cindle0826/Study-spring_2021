package com.study.spring.case6.tx.exception;

public class InsufficientAmount extends Throwable{
	public InsufficientAmount() {
		super("餘額不足");
	}
}
