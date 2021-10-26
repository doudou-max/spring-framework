package org.springframework.aop.demo3;

import org.springframework.objenesis.Objenesis;
import org.springframework.objenesis.ObjenesisStd;
import org.springframework.objenesis.instantiator.ObjectInstantiator;

/**
 * @author: doudou
 * @since: 2021-10-26
 */
public class ObjenesisStdMain {

	public static void main(String[] args) throws Exception {
		Objenesis objenesis = new ObjenesisStd();
		// 相当于生成了一个实例创建的工厂，接下来就可以很方便得创建实例了
		// 如果你要创建多个实例，建议这么来创建
		ObjectInstantiator<ObjenesisDemo> instantiator = objenesis.getInstantiatorOf(ObjenesisDemo.class);

		ObjenesisDemo myDemo1 = instantiator.newInstance();
		ObjenesisDemo myDemo2 = instantiator.newInstance();
		System.out.println(myDemo1);
		System.out.println(myDemo1.code); //null
		System.out.println(myDemo2);
	}

}
