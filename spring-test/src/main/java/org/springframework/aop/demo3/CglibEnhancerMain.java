package org.springframework.aop.demo3;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * @author: doudou
 * @since: 2021-10-26
 */
public class CglibEnhancerMain {

	/**
	 * 也是位于 cglib 相关的包内。org.springframework.cglib.proxy
	 * CGLIB 是一个强大的高性能的代码生成包。它被许多AOP的框架(例如Spring AOP)使用，为他们提供方法的interception(拦截)
	 *
	 * CGLIB 包的底层是通过使用一个小而快的字节码处理框架ASM，来转换字节码并生成新的类。
	 * 不鼓励直接使用ASM，因为它要求你必须对JVM内部结构包括class文件的格式和指令集都很熟悉
	 */
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(ObjenesisDemo.class);
		// 注意此处得 MethodInterceptor 是 cglib 包下的，AOP联盟里还有一个MethodInterceptor
		enhancer.setCallback((MethodInterceptor) (o, method, args1, methodProxy) -> {
			System.out.println(method.getName() + "---方法拦截前");
			// 此处千万不能调用method得invoke方法，否则会死循环的 只能使用methodProxy.invokeSuper 进行调用
			//Object result = method.invoke(o, args1);
			Object result = methodProxy.invokeSuper(o, args1);
			System.out.println(method.getName() + "---方法拦截后");
			return result;
		});

//		//MyDemo myDemo = (MyDemo) enhancer.create(); // 这里是要求必须有空的构造函数的
//		ObjenesisDemo myDemo = (ObjenesisDemo) enhancer.create(new Class[]{String.class}, new Object[]{"fsx"});
//		// 直接打印：默认会调用toString方法以及hashCode方法  此处都被拦截了
//		System.out.println(myDemo);
		//System.out.println(myDemo.code);

	}

}
