package org.springframework.proxy.impl;

import org.springframework.proxy.Helloworld;

/**
 * @author: doudou
 * @since: 2021-10-25
 */
public class HelloworldImpl implements Helloworld {

	@Override
	public void sayHello() {
		System.out.println("hello world");
	}

}
