package com.study.spring.case05.proxy;

import org.springframework.cglib.proxy.Enhancer;

public class HelloTest {
	public static void main(String[] args) {
		Hello hello = new Hello();
		System.out.println(hello.sayHello("Yun"));
		System.out.println();
		//使用 cglib
		Enhancer enhancer = new Enhancer(); // 增強
		enhancer.setSuperclass(Hello.class);
		enhancer.setCallback(new MymethodInterceptor());
		
		Hello hello2 = (Hello) enhancer.create();
		System.out.println(hello2.sayHello("Vincent"));
	}

}
