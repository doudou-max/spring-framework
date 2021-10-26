package org.springframework.aop.demo3;

import org.springframework.objenesis.Objenesis;
import org.springframework.objenesis.SpringObjenesis;

/**
 * @author: doudou
 * @since: 2021-10-26
 *
 * 这是 spring 对 Objenesis 接口的一个实现。由 Spring4.2 之后提供的 (ObjenesisCglibAopProxy 可是 Spring4.0 就有了)
 *
 * Objenesis VS class.newInstance
 *   从以上代码可以发现 class 构造器需要参数，而 Objenesis 可以绕过去， Objenesis 主要应用场景：
 * 	   序列化，远程调用和持久化 -对象需要实例化并存储为到一个特殊的状态，而没有调用代码
 *     代理，AOP库和Mock对象 -类可以被子类继承而子类不用担心父类的构造器。
 *     容器框架 -对象可以以非标准的方式被动态实例化（比如Spring就是容器框架）。
 *
 */
public class SpringObjenesisMain {

	public static void main(String[] args) {

		Objenesis objenesis = new SpringObjenesis();

		// Spring为我们提供了一个isWorthTrying()方法：

	}

	// 是否需要尝试：也就是说，它是否还没有被使用过，或者已知是否有效。方法返回true，表示值得尝试
	// 如果配置的 Objenesis Instantiator 策略被确定为不处理当前JVM。或者系统属性"spring.objenesis.ignore"值设置为true，表示不尝试了
	// 这个在 ObjenesisCglibAopProxy 创建代理实例的时候用到了。若不尝试使用Objenesis，那就还是用老的方式用空构造函数吧

//	public boolean isWorthTrying() {
//		return (this.worthTrying != Boolean.FALSE);
//	}


}
