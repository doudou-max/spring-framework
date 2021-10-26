package org.springframework.aop.demo3;

import org.springframework.cglib.core.DefaultGeneratorStrategy;
import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.cglib.proxy.CallbackHelper;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.objenesis.Objenesis;
import org.springframework.objenesis.SpringObjenesis;

import java.lang.reflect.Method;

/**
 * @author: doudou
 * @since: 2021-10-26
 */
public class CglibEnhancer2Main {

	/**
	 * CGLIB 整个过程如下：
	 * 	 Cglib 根据父类，Callback, Filter 及一些相关信息生成 key
	 *   然后根据 key，生成对应的子类的二进制表现形式
	 *   使用 ClassLoader 装载对应的二进制，生成 Class 对象，并缓存
	 *   最后实例化 Class 对象，并缓存
	 */
	public static void main(String[] args) {
//		Enhancer enhancer = new Enhancer();
//		enhancer.setSuperclass(ObjenesisDemo.class);
//
//		// 如国实用createClass方式来创建代理的实例  是不能直接添加callback得
//		// enhancer.setCallback();
//		enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);
//		enhancer.setStrategy(new DefaultGeneratorStrategy());
//		enhancer.setCallbackFilter(new CallbackHelper(ObjenesisDemo.class, null) {
//			@Override
//			protected Object getCallback(Method method) {
//				return (MethodInterceptor) (o, method1, args1, methodProxy) -> {
//					System.out.println(method1.getName() + "---方法拦截前");
//					// 此处千万不能调用method得invoke方法，否则会死循环的 只能使用methodProxy.invokeSuper 进行调用
//					// Object result = method.invoke(o, args1);
//					Object result = methodProxy.invokeSuper(o, args1);
//					System.out.println(method1.getName() + "---方法拦截后");
//					return result;
//				};
//			}
//		});
//		enhancer.setCallbackTypes(new Class[]{MethodInterceptor.class});
//
//		// 这里我们只生成Class字节码，并不去创建对象
//		Class clazz = enhancer.createClass();
//		// 创建对象的操作交给
//		Objenesis objenesis = new SpringObjenesis();
//		ObjenesisDemo myDemo = (ObjenesisDemo) objenesis.newInstance(clazz);
//
//		System.out.println(myDemo);
//		System.out.println(myDemo.code);

	}

}
