package com.study.spring.case05.aopxml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class MyLoggerXMLAspect {
//	public void before(JoinPoint joinPoint) {
//		System.out.println("AOP XML 版 - 前置通知");
//		String methodName = joinPoint.getSignature().getName();
//		Object[] args = joinPoint.getArgs();
//		System.out.printf("方法名稱:%s，方法參數:%s\n",methodName,Arrays.toString(args));
//	}
	
	public Object around(ProceedingJoinPoint joinPoint) {
		Object obj = null;
		try {
			System.out.println(" 前置通知 ");
			obj = joinPoint.proceed();
			System.out.println(" 返回通知 " + obj);
		} catch (Throwable t) {
			System.out.println(" 例外通知 " + t);

		}finally {
			System.out.println(" 後置通知 ");
			
		}
		return obj;
	}
}
