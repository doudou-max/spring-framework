package com.ww;

import com.ww.dao.Dao;
import org.springframework.stereotype.Component;

/**
 * @author: doudou
 * @since: 2022-08-07
 */
@Component
public class IndexDao implements Dao {
	@Override
	public void query() {
		System.out.println("query ......");
	}
}
