package com.study.spring.case05.proxy;

public class EnhancerHello extends Hello {
	public static void main(String[] args) {
		Hello hello = new EnhancerHello();
		
		
	}

	@Override
	public String sayHello(String str) {
		return super.sayHello(str)+"請出示實聯制";
	}
}
