package org.springframework.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.proxy.cglib.interceptor.MyMethodInterceptor;
import org.springframework.proxy.impl.HelloworldImpl;

/**
 * @author: doudou
 * @since: 2021-10-25
 */
public class CglibMain {

	// 此处需要说明：Enhancer实际属于CGLIB包的，也就是 `net.sf.cglib.proxy.Enhancer`
	// 但是Spring把这些类都拷贝到自己这来了，因此我用的Spring的Enhancer，包名为;`org.springframework.cglib.proxy.Enhancer`
	public static void main(String[] args) throws Exception {

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(HelloworldImpl.class); // 注意此处的类型必须是实体类
		enhancer.setCallback(new MyMethodInterceptor());

		HelloworldImpl helloService = (HelloworldImpl) enhancer.create();
		helloService.sayHello();
	}

}
