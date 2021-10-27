package org.springframework.aop.demo;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.SpringProxy;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.core.DecoratingProxy;

import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author: doudou
 * @since: 2021-10-25
 */
public class AopJdkMain {

	public static void main(String[] args) {

		Demo classDemo = new Demo();
		ProxyFactory proxyFactory = new ProxyFactory(classDemo);
		// () -> sys.out 的操作，相当于是对接口的实现，然后将其转成 MethodBeforeAdvice
		// toString() 方法会被拦截增强
		// advice 通知
		proxyFactory.addAdvice((MethodBeforeAdvice) (method, args1, target) -> System.out.println("你被拦截了：方法名为：" + method.getName() + " 参数为--" + Arrays.asList(args1)));

		// 这里拿到的是一个代理对象，不是通过对类的实例化拿到
		DemoInterface demo = (DemoInterface) proxyFactory.getProxy();
		// 你被拦截了：方法名为：hello 参数为--[]
		// this demo show
		// 在这一步去调用 invoke()，通过代理对象去调用对应的类中的方法
		demo.hello();


		System.out.println("-----------------------------------------------------");


		System.out.println(proxyFactory.getTargetClass()); // class org.springframework.aop.demo.Demo
		System.out.println(proxyFactory.getTargetSource()); // SingletonTargetSource for target object [org.springframework.aop.demo.Demo@3224f60b]
		System.out.println(Arrays.asList(proxyFactory.getProxiedInterfaces())); // [interface org.springframework.aop.demo.DemoInterface]
		// advisors 通过 + 切入点配置
		System.out.println(Arrays.asList(proxyFactory.getAdvisors())); // [org.springframework.aop.support.DefaultPointcutAdvisor: pointcut [Pointcut.TRUE]; advice [org.springframework.aop.demo.AopMain$$Lambda$1/873415566@63e2203c]]

		// 获取类型，看看是JDK代理还是cglib的
		System.out.println(demo instanceof Proxy); // true  所有的 JDK代理 都是继承自 Proxy
		System.out.println(demo instanceof SpringProxy); // true
		System.out.println(demo.getClass()); // class com.fsx.maintest.$Proxy0
		System.out.println(Proxy.isProxyClass(demo.getClass())); // true
		System.out.println(AopUtils.isCglibProxy(demo)); // false

		// 测试 Advised 接口、DecoratingProxy 的内容
		Advised advised = (Advised) demo;
		System.out.println(Arrays.asList(advised.getProxiedInterfaces())); // [interface org.springframework.aop.demo.DemoInterface]
		System.out.println(Arrays.asList(advised.getAdvisors())); // [org.springframework.aop.support.DefaultPointcutAdvisor: pointcut [Pointcut.TRUE]; advice [org.springframework.aop.demo.AopMain$$Lambda$1/873415566@63e2203c]]
		System.out.println(advised.isExposeProxy()); // false
		System.out.println(advised.isFrozen()); // false

		//System.out.println(advised.removeAdvice(null));
		DecoratingProxy decoratingProxy = (DecoratingProxy) demo;
		System.out.println(decoratingProxy.getDecoratedClass()); // class org.springframework.aop.demo.Demo

		System.out.println("-----------------------------------------------------");

		// Object的方法 ==== 所有的Object方法都不会被AOP代理 这点需要注意
		System.out.println(demo.equals(new Object())); // false
		System.out.println(demo.hashCode()); // 177161247
		System.out.println(demo.getClass()); // class com.sun.proxy.$Proxy0

		// 其余方法都没被拦截  只有toString()被拦截了  咋回事呢？它也不符合切点表达式的要求啊  看下面的解释吧
		// 你被拦截了：方法名为：toString 参数为--[]
		// org.springframework.aop.demo.Demo@3224f60b
		System.out.println(demo.toString());
	}

}
