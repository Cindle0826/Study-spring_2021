package com.study.spring.case05.proxy;

import java.util.Arrays;

//Aspect
public class MyLogger {
	// 前置通知
	public static void before(Class cls, String methofName, Object[] args) {
		System.out.printf("前置通知: %s %s %s\n", cls, methofName, Arrays.toString(args));
	}

	// 後置通知
	public static void after(Class cls, String methofName, Object result) {
		System.out.printf("後置通知: %s %s %s\n", cls, methofName, result);
	}

	// 異常通知
	public static void throwing(Class cls, String errorMessage) {
		System.out.printf("例外通知: %s %s %s\n", cls, errorMessage);
	}
}
