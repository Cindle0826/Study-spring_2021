package com.study.spring.case05.aopxml;

import org.springframework.stereotype.Component;

@Component
public class CalcImpl implements Calc {
	@Override
	public Integer add(int x, int y) {
		int result = x + y;
		return result;
	}

	@Override
	public Integer div(int x, int y) {
		int result = x / y;
		return result;

	}
}
