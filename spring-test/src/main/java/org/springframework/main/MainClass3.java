package org.springframework.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.model.User;
import org.springframework.model.User2;

/**
 * @author: doudou
 * @since: 2021-10-14
 */
public class MainClass3 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-aware.xml");

		User user=context.getBean(User.class);
		System.out.println(String.format("实现了 BeanNameAware 接口的信息BeanId=%s,所有信息=%s",user.getId(),user.toString()));

		User2 user2=context.getBean(User2.class);
		System.out.println(String.format("未实现 BeanNameAware 接口的信息BeanId=%s,所有信息=%s",user2.getId(),user2.toString()));
	}

}
