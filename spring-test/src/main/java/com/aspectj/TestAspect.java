package com.aspectj;

import com.aspectj.dao.DemoDao;
import com.aspectj.dao2.DemoDaoImpl;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: doudou
 * @since: 2022-08-07
 */
public class TestAspect {

	public static void main(String[] args) {

		// 设置CGLib代理类的生成位置
		// System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "./cg");

		// 设置JDK代理类的输出
		// System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

		// 这一步已经生成代理对象，是非懒加载的方式加载
		// 在容器初始化刷新的时候已经向 bean 容器中添加： AnnotationAwareAspectJAutoProxyCreator 对象
		AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(DemoAspectJConfig.class);

		// 这一步只是获取bean对象而已，并不是 getBean 去创建对象
		DemoDao dao = configApplicationContext.getBean(DemoDao.class);

		dao.query();
	}

}

