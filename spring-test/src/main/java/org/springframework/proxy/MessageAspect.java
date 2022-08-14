package org.springframework.proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: doudou
 * @since: 2022-08-07
 */
@EnableAspectJAutoProxy
public class MessageAspect {

	@Pointcut("execution(public * org.springframework.demo.*(..)))")
	public void flowCount() {
	}

	@Around("flowCount()")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("hello aspect");
		joinPoint.proceed();
		return new Object();
	}



}
