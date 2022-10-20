package com.autowire;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author: doudou
 * @since: 2022-10-20
 */
public class AutowireMain {

	public static void main(String[] args) {

		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(DemoController.class);
		beanFactory.registerBeanDefinition("demoController", definitionBuilder.getBeanDefinition());

		definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(DemoService.class);
		beanFactory.registerBeanDefinition("demoService", definitionBuilder.getBeanDefinition());

		AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
		autowiredAnnotationBeanPostProcessor.setBeanFactory(beanFactory);
		beanFactory.addBeanPostProcessor(autowiredAnnotationBeanPostProcessor);

		DemoController demoController = (DemoController) beanFactory.getBean("demoController");
		System.out.println(demoController.demo());

	}

}
