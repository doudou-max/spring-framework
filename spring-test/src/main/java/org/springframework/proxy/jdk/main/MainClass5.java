package org.springframework.proxy.jdk.main;

import org.springframework.proxy.Helloworld;
import org.springframework.proxy.jdk.handler.MyInvocationHandler;
import org.springframework.proxy.impl.HelloworldImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author: doudou
 * @since: 2021-10-25
 */
public class MainClass5 {

	public static void main(String[] args) throws Exception {

		// 方式一：
		//   传入三大参数，就能够创建出一个代理对象，通过代理对象去代理调用方法
		Helloworld helloWorld = (Helloworld) Proxy.newProxyInstance(
				MainClass5.class.getClassLoader(),
				new Class<?>[]{Helloworld.class},
				new MyInvocationHandler(new HelloworldImpl())); //此处目标实现为 HelloworldImpl

		helloWorld.sayHello();


		// 方式二：
        // 	 1、生成代理接口的 Class()  class com.sun.proxy.$Proxy0
        //   2、拿到构造器：public com.sun.proxy.$Proxy0(java.lang.reflect.InvocationHandler)
        //   3、new 一个 InvocationHandler 实例
//        Class<?> proxyClass = Proxy.getProxyClass(MainClass5.class.getClassLoader(), Helloworld.class);
//        Constructor<?> cons = proxyClass.getConstructor(InvocationHandler.class);
//        InvocationHandler ih = new MyInvocationHandler(new HelloworldImpl());
//        // 通过构造函数 new 出一个实例
//        Helloworld helloWorld2 = (Helloworld) cons.newInstance(ih);
//        helloWorld2.sayHello();

	}

}
