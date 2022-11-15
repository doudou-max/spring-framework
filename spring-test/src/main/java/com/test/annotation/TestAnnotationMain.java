package com.test.annotation;

import com.test.annotation.bean.ConfigBean;
import com.test.annotation.configuration.TestConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: doudou
 * @since: 2022-11-15
 */
public class TestAnnotationMain {

	public static void main(String[] args) {
		//ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.test.annotation.configuration");
		ConfigBean configBean = applicationContext.getBean(ConfigBean.class);
		System.out.println(configBean.sayConfig("doudou"));
	}

}
