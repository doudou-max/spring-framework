package com.ww;

import com.ww.dao.Dao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: doudou
 * @since: 2022-08-07
 */
public class TestAspect {

	public static void main(String[] args) {
		// 这一步已经生成代理对象
		AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(Wconfig.class);

		Dao dao = configApplicationContext.getBean(Dao.class);

		dao.query();
	}

}

