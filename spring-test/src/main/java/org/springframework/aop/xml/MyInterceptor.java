package org.springframework.aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author: doudou
 * @since: 2021-10-27
 * 自定义 aop 通知
 */
public class MyInterceptor {

	// 1.前置
	public void doAccessCheck() {
		System.out.println("前置通知-->>");
	}

	// 6.后置
	public void doAfterReturning() {
		System.out.println("后置通知-->>");
	}

	// 4.最终
	public void doAfter() {
		System.out.println("最终通知-->>");
	}

	public void doAfterThrowing() {
		System.out.println("异常通知-->>");
	}

	// 2.环绕
	public Object doAround(ProceedingJoinPoint pJoinPoint) throws Throwable {
		System.out.println("环绕通知-->>");
		// 这里如果 pJoinPoint.proceed() 不执行，后面拦截到的方法都不会执行，非常适用于权限管理
		Object result = pJoinPoint.proceed();

		// 3.业务代码

		// 5.退出
		System.out.println("退出");
		return result;
	}


	/*

	  前置通知-->>
	  环绕通知
      save()->>LinDL
      最终通知
      退出
      后置通知-->>


	  前置通知-->>
      环绕通知
	  最终通知
	  退出
      后置通知

	*/

}
