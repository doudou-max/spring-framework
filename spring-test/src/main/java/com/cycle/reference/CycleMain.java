package com.cycle.reference;

import com.ww.Wconfig;
import com.ww.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: doudou
 * @since: 2022-08-13
 * spring 处理循环依赖
 */
public class CycleMain {

	/**
	 * spring 如何处理循环依赖 ?
	 * 	spring 将发生循环依赖的 bean 放入三级缓存
	 *  	refresh()
	 *  	invokeBeanFactoryPostProcessors() 	将所有的 BeanPostProcessor 放入容器
	 *  		SmartInstantiationAwareBeanPostProcessor.getEarlyBeanReference(Object bean, String beanName) 获取二级缓存对象
	 *  	finishBeanFactoryInitialization()
	 *  	beanFactory.preInstantiateSingletons()
	 *  	getBean(beanName)	 else 的方法
	 *
	 *
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		// 模拟循环依赖

		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(AService.class);
		beanFactory.registerBeanDefinition("aService", definitionBuilder.getBeanDefinition());

		definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(BService.class);
		beanFactory.registerBeanDefinition("bService", definitionBuilder.getBeanDefinition());

		//AutowiredAnnotationBeanPostProcessor不仅会处理@Autowrired注解，还会在创建Bean时选择最合适的构造器
		AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
		autowiredAnnotationBeanPostProcessor.setBeanFactory(beanFactory);
		beanFactory.addBeanPostProcessor(autowiredAnnotationBeanPostProcessor);

		AService aService = (AService) beanFactory.getBean("aService");
		aService.bSay();

	}

}
