package org.springframework;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.component.DemoComponent;
import org.springframework.configuration.DemoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.demo.MessageService;
import org.springframework.model.User;

/**
 * @author: doudou
 * @since: 2021-10-12
 */
@EnableAspectJAutoProxy
@ComponentScan("org.springframework")
public class MainClass {

	public static void main(String[] args) {

//		// xml 方式
//		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
//
//		// 从 context 中取出 Bean
//		MessageService messageService = context.getBean(MessageService.class);
//		System.out.println(messageService.getMessage());

//		ApplicationContext context = new AnnotationConfigApplicationContext(DemoComponent.class, User.class);
//		DemoComponent demoComponent = context.getBean(DemoComponent.class);
//		System.out.println("---------------" + demoComponent.say());

//		User user = context.getBean(User.class);
//		System.out.println("---------------" + user.say());
//
//		ApplicationContext context2 = new ClassPathXmlApplicationContext("classpath:application.xml");
//		MessageService messageService = context2.getBean(MessageService.class);
//		System.out.println("---------------" + messageService.getMessage());

		// 注解 applicationContext，必须结合 @Configuration 和 @Bean 一起使用
		ApplicationContext context = new AnnotationConfigApplicationContext("org.springframework.controller", "org.springframework.component");
		DemoComponent demoComponent = context.getBean(DemoComponent.class);
		System.out.println("---------------" + demoComponent.say());

//		DemoComponent bean = context.getBean(DemoComponent.class);
//		System.out.println("---------------" + bean.say());

//		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainClass.class);
//		MessageService messageService = (MessageService)applicationContext.getBean("messageService");
//		System.out.println(messageService.getMessage());


	}

}
