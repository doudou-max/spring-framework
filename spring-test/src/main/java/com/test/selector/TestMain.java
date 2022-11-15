package com.test.selector;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * @author: doudou
 * @since: 2022-11-15
 */
@Import(TestDeferredImportSelector.class)
public class TestMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestMain.class);
		TestBean testBean = applicationContext.getBean(TestBean.class);
		System.out.println(testBean.sayTest("doudou"));
	}

}
