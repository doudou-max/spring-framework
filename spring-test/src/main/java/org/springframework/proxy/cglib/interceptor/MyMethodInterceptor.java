package org.springframework.proxy.cglib.interceptor;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: doudou
 * @since: 2021-10-25
 */
public class MyMethodInterceptor implements MethodInterceptor {

	@Override
	public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		Object intercept = methodProxy.invokeSuper(object, args); // 注意这里调用的是methodProxy.invokeSuper
		System.out.println("中介：该房源已发布！");
		return intercept;
	}

}
