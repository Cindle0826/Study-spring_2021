package com.study.spring.case05.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aopConfig.xml");
		Calc calc = ctx.getBean("calcImpl",Calc.class);
		calc.add(1, 2);
		calc.div(10, 5);
	}
}
