package com.aspectj.dao2;

import com.aspectj.dao.DemoDao;
import org.springframework.stereotype.Component;

/**
 * @author: doudou
 * @since: 2022-08-07
 */
@Component
public class DemoDaoImpl implements DemoDao {
	@Override
	public void query() {
		System.out.println("query ......");
	}
}


//@Component
//public class DemoDaoImpl {
//	public void query() {
//		System.out.println("query ......");
//	}
//}