package org.springframework.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author: doudou
 * @since: 2021-10-13
 */
public class MainClass2 {

	@Autowired
	private BeanFactory beanFactory;
	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	//web环境下
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	@Autowired
	private HttpSession session;
	@Autowired
	private WebRequest webRequest;

//	@Override
	public Object hello() {
//		System.out.println(beanFactory); //org.springframework.beans.factory.support.DefaultListableBeanFactory@3ff27f35
//		System.out.println(applicationContext); //Root WebApplicationContext: startup date [T ...
//		System.out.println(applicationEventPublisher); //Root WebApplicationContext: startup date [T ...
//		// 我们发现的是同一个Bean
//		System.out.println(System.identityHashCode(applicationEventPublisher) == System.identityHashCode(applicationContext)); //true
//
//		//web环境
//		// =================必须说明一点：这里注入的所有web对象，都是线程安全的=================
//		// 请求N次，每次输出的HashCode都是一样的，那怎么还没有线程安全问题呢？具体看下面分解原因
//		System.out.println(System.identityHashCode(request));
//		System.out.println(request.getClass()); //class com.sun.proxy.$Proxy22  这是个代理对象哟~~~~
//
//		System.out.println(request); //Current HttpServletRequest
//		System.out.println(response); //Current HttpServletResponse
//		System.out.println(session); //Current HttpSession
//		System.out.println(webRequest); //Current ServletWebRequest

		return "service hello";
	}

	public static void main(String[] args) {
		MainClass2 class2 = new MainClass2();
		class2.hello();
	}


}
