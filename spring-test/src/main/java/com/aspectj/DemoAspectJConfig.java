package com.aspectj;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: doudou
 * @since: 2022-08-07
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.aspectj")
public class DemoAspectJConfig {
	// @EnableAspectJAutoProxy 开启注解 aop 功能
	// 向 spring 容器中已经加入 AnnotationAwareAspectJAutoProxyCreator bean 实例
}
