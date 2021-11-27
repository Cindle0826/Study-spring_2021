package com.study.spring.case05.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyUtil {
	private Object object;

	public ProxyUtil(Object object) {
		this.object = object;
	}

	public Object getProxy() {
		// 類別載入器
		ClassLoader loader = getClass().getClassLoader();
		// 目標所實作的介面
		Class [] interfaces= object.getClass().getInterfaces();
		// 處理代理的實現
		InvocationHandler handler = (Object proxy, Method method, Object[] args) ->{
			Object result = null;
			try {
				// 前置通知
				System.out.println("前置 Log:" + object.getClass() + " , " + method.getName() + " , "+ Arrays.toString(args));
				result = method.invoke(object, args);//返回通知
				return result;
			} catch (Exception e) {
				e.printStackTrace(System.out);
				// 例外異常通知
				System.out.println("例外 Log:" + object.getClass() + " , " + e );
			}finally {
				// 後置通知
				System.out.println("後置 Log:" + object.getClass() + " , " + method.getName() + " " + result);
			}
			return null;
		};
		Object proxyObject = Proxy.newProxyInstance(loader, interfaces, handler);
		return proxyObject;
	}
}
