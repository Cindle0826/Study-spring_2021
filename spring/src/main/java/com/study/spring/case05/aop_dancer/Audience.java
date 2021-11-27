package com.study.spring.case05.aop_dancer;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Audience {
	// 切面程式可以指向interface
	@Before("execution(public void com.study.spring.case05.aop_dancer.Performance.*(..))")
	public void slienceCellPhone() {
		System.out.println("關掉手機");
	}

	@AfterReturning("execution(public void com.study.spring.case05.aop_dancer.Performance.*(..))")
	public void applause() {
		System.out.println("拍手");
	}

	@AfterThrowing("execution(public void com.study.spring.case05.aop_dancer.Performance.*(..))")
	public void demandRefund() {
		System.out.println("退票!退票!");
	}
	
	@After("execution(public void com.study.spring.case05.aop_dancer.Performance.*(..))")
	public void exit() {
		System.out.println("離開");
	}

}