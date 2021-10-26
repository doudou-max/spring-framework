package org.springframework.aop.demo3;

import org.springframework.objenesis.Objenesis;
import org.springframework.objenesis.ObjenesisStd;

/**
 * @author: doudou
 * @since: 2021-10-26
 */
public class ObjenesisMain {

	/**
	 * Objenesis：另一种实例化对象的方式
	 * 它专门用来创建对象，即使你没有空的构造函数，都木有问题~~ 可谓非常的强大
	 * 它不使用构造方法创建Java对象，所以即使你有空的构造方法，也是不会执行的。
	 *
	 * Objenesis是一个Java的库，主要用来创建特定的对象。
	 *
	 * 由于不是所有的类都有无参构造器又或者类构造器是private，在这样的情况下，如果我们还想实例化对象，class.newInstance是无法满足的。
	 */
	public static void main(String[] args) throws Exception {
		Objenesis objenesis = new ObjenesisStd();
		// 它竟然创建成功了
		ObjenesisDemo myDemo = objenesis.newInstance(ObjenesisDemo.class);
		System.out.println(myDemo); //com.fsx.maintest.MyDemo@1f32e575
		System.out.println(myDemo.code); //null  特别注意：这里是null，而不是10

		// 若直接这样创建 就报错 java.lang.InstantiationException: com.fsx.maintest.MyDemo
		//System.out.println(ObjenesisDemo.class.newInstance());
	}

}
