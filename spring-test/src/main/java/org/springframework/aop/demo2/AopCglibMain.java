package org.springframework.aop.demo2;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.util.Arrays;

/**
 * @author: doudou
 * @since: 2021-10-25
 */
public class AopCglibMain {

	public static void main(String[] args) {

		ProxyFactory proxyFactory = new ProxyFactory(new Demo2());
		proxyFactory.addAdvice((MethodBeforeAdvice) (method, args1, target) -> System.out.println("你被拦截了：方法名为：" + method.getName() + " 参数为--" + Arrays.asList(args1)));

		Demo2 demo = (Demo2) proxyFactory.getProxy();
		// 你被拦截了：方法名为：hello 参数为--[]
		demo.hello(); //this demo show
	}

}
