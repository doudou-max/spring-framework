package org.springframework.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.model.User;

/**
 * @author: doudou
 * @since: 2021-10-18
 */
@Configuration	// 1
public class DemoConfiguration {

	@Bean   // 2. 标注注解，并且被 AnnotationConfigApplicationContext 扫描到，才注入到 beanFactory 中
	public User sayBean() {
		return new User();
	}
}
