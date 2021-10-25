package org.springframework.proxy.jdk.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: doudou
 * @since: 2021-10-25
 */
public class MyInvocationHandler implements InvocationHandler {

	private final Object target;

	public MyInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("method :" + method.getName() + " is invoked!");
		return method.invoke(target, args);
	}

}
