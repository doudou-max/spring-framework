package org.springframework.aop.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: doudou
 * @since: 2021-10-27
 */
public class AopXmlMain {

	public static void main(String[] args) {

		// 在 refresh() 方法中，会去解析 xml 文件，然后得到 aop 的定义，注入到 beanFactory 中
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("myAop.xml");
		PersonService pService = (PersonService) context.getBean("personService");
		pService.save("LinDL");
		// pService.getResult();
		// context.close();
	}

}
