package com.study.spring.case05.aop;


import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect 	//切面
@Order(1)
public class MyLoggerAspect {
	// Pointcut 切入點是用來定義連接點 JoinPoint 連接點
	@Pointcut(value = "execution(public Integer com.study.spring.case05.aop.CalcImpl.*(..))")
	public void pt() {}
	@Pointcut(value = "execution(public Integer com.study.spring.case05.aop.CalcImpl.div(..))")
	public void pt2() {}
	//前置通知
//	@Before(value = "execution(public int com.study.spring.case05.aop.CalcImpl.add(int,int))") execution ( 存取權限 + 回傳值 + package + class + method + (parameter,parameter))
//	@Before(value = "execution(public int com.study.spring.case05.aop.CalcImpl.*(..))")  
//	@Before(value = "execution(public int com.study.spring.case05.aop.*.*(..))")  
//	@Before(value = "execution(* *.*(..))")  
//	@Before(value = "pt() && !pt2()") //支援 &&、||、!
	/**
 	@Before(value = "pt()")
	public void before(JoinPoint joinPoint) {
		System.out.println("前置通知 -");
		String methodName = joinPoint.getSignature().getName(); //獲取方法
		Object [] args = joinPoint.getArgs(); //獲取方法參數
		System.out.printf("方法名稱:%s，方法參數:%s\n",methodName,Arrays.toString(args));
	}
	
	// 後置通知 放在finally區段中，無論拋出例外都會執行
	@After(value = "pt()")
	public void after() {
		System.out.println("後置通知 -");
	}
	
	// 返回通知 (可以設定 returning 來接受方法的返回值)
	@AfterReturning(value = "pt()",returning = "result")
	public void afterReturning(Object result) {
		System.out.println("返回通知 - result: " + result);
	}
	
	//異常通知 (可以設定 thorwing 內容)
	@AfterThrowing(value = "pt()",throwing = "ex")
	public void afterThrowing(Exception ex) {
		System.out.println("異常通知 - ex: "+ ex);
	}
	*/
	//環繞通知
	@Around(value = "pt()")
	public Object around(ProceedingJoinPoint joinPoint)  {
		Object result = "null";
		try {
			System.out.println("環繞通知 - 前置通知");
			result = joinPoint.proceed();
			System.out.println("環繞通知 - 返回通知"+result);
			
		} catch (Throwable throwable) {
			System.out.println("環繞通知 - 異常通知");

		} finally {
			System.out.println("環繞通知 - 後置通知");
			
		}
		return result;

	}
	
}
