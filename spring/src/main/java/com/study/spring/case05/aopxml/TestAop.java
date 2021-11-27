package com.study.spring.case05.aopxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aopxml.xml");
		Calc calc = (Calc) ctx.getBean("calcImpl");
		calc.add(10, 30);
		
		
	}
}
