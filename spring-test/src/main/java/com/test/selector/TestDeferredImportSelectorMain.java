package com.test.selector;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * @author: doudou
 * @since: 2022-11-15
 * 查看 DeferredImportSelector 执行流程
 */
@Import(TestDeferredImportSelector.class)
public class TestDeferredImportSelectorMain {

	public static void main(String[] args) {
		// 这里执行流程：
		//	  TestDeferredImportSelectorMain 会被注册到容器中
		//    然后遍历容器中的 bean 对象，判断是否是为配置类
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestDeferredImportSelectorMain.class);
		TestBean testBean = applicationContext.getBean(TestBean.class);
		System.out.println(testBean.sayTest("doudou"));
	}

}
