package org.springframework.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.model.User;

/**
 * @author: doudou
 * @since: 2021-10-18
 */
@Configuration
public class DemoConfiguration {

	@Bean
	public User sayBean() {
		return new User();
	}
}
