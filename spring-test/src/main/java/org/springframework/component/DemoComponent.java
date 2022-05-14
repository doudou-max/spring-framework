package org.springframework.component;

import org.springframework.stereotype.Component;

/**
 * @author: doudou
 * @since: 2021-10-18
 */
@Component  // 标注注解，并且被 AnnotationConfigApplicationContext 扫描到，才注入到 beanFactory 中
public class DemoComponent {

	public String say() {
		return "hello @Component";
	}

}
