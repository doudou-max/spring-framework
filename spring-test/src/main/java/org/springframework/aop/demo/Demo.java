package org.springframework.aop.demo;

/**
 * @author: doudou
 * @since: 2021-10-25
 */
public class Demo implements DemoInterface {

	@Override
	public void hello() {
		System.out.println("this demo show");
	}

}