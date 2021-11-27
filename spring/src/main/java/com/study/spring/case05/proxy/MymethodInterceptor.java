package com.study.spring.case05.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class MymethodInterceptor  implements MethodInterceptor{

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("麻煩請出示實聯制");
		return proxy.invokeSuper(obj, args);
	}
	
}
