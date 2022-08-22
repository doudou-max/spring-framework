package com.aspectj.generate;

import com.aspectj.dao.DemoDao;
//import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: doudou
 * @since: 2022-08-15
 */
public class GenerateMain {

	public static void main(String[] args) throws IOException {

		// JdkDynamic 生成代理的 .class 文件，生成的类通过反编译，可以看到已经基础 extends Proxy
		/*byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy", new Class[]{DemoDao.class});
		FileOutputStream fileOutputStream = new FileOutputStream("/Users/apple/Desktop/sql/HomeService.class");
		fileOutputStream.write(bytes);
		fileOutputStream.flush();
		fileOutputStream.close();*/



		// Cglib 动态代理生成
		// https://blog.csdn.net/Aphysia/article/details/121218079
		// 这种方式会生成三个 .class 文件，最主要的文件通过 extends TargetSource，重写目标类的方法对目标类进行增强


		// JdkDynamic 一定要通过接口生成
		// Cglib 不强制

		// cglib 和 jdk 动态代理有什么区别
		//	 jdk 动态代理是利用拦截器加上反射生成了一个代理接口的匿名类，执行方法的时候交给 InvokeHandler 处理
		//	 CGLIB 动态代理是使用了 ASM框架，修改原来的字节码，然后生成新的子类来处理
		//   JDK 代理需要实现接口，但是 CGLIB 不强制
		//   在 JDK1.6 之前，cglib 因为用了字节码生成技术，比反射效率高，但是之后 jdk 也进行了一些优化，效率上已经提升了
	}


}
