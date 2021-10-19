package org.springframework;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.component.DemoComponent;
import org.springframework.configuration.DemoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.demo.MessageService;
import org.springframework.model.User;

/**
 * @author: doudou
 * @since: 2021-10-12
 */
public class MainClass {

	public static void main(String[] args) {
//		// 用我们的配置文件来启动一个 ApplicationContext
//		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
//
//		System.out.println("context 启动成功");
//
//		// 从 context 中取出我们的 Bean，而不是用 new MessageServiceImpl() 这种方式
//		MessageService messageService = context.getBean(MessageService.class);
//
//		// 这句将输出: hello world
//		System.out.println(messageService.getMessage());


		ApplicationContext context = new AnnotationConfigApplicationContext(DemoComponent.class, User.class);
		DemoComponent demoComponent = context.getBean(DemoComponent.class);
		System.out.println("---------------" + demoComponent.say());

//		User user = context.getBean(User.class);
//		System.out.println("---------------" + user.say());
//
//		ApplicationContext context2 = new ClassPathXmlApplicationContext("classpath:application.xml");
//		MessageService messageService = context2.getBean(MessageService.class);
//		System.out.println("---------------" + messageService.getMessage());

	}

}
