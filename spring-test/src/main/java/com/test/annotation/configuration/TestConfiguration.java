package com.test.annotation.configuration;

import com.test.annotation.bean.ConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: doudou
 * @since: 2022-11-15
 */
@Configuration
public class TestConfiguration {

	public TestConfiguration() {
		System.out.println("TestConfiguration 构造方法");
	}

	@Bean
	public ConfigBean configBean() {
		return new ConfigBean();
	}

}
