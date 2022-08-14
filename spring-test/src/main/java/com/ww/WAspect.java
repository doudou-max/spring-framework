package com.ww;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author: doudou
 * @since: 2022-08-07
 */
//代表是一个切面
@Aspect
@Component
public class WAspect {

	/**
	 * execution表达式，可以百度写法
	 */
	@Pointcut("execution(* com.ww.dao.*.*(..))")
	public void point(){

	}

	/**
	 * 在切点上进行前置通知
	 */
	@Before("point()")
	public void beforeAd(){
		System.out.println("before-------------");
	}
}

