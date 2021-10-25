/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.aop.framework.adapter;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;

import org.springframework.aop.Advisor;

/**
 * Advisor: 通知 + 切入点 适配器
 *
 * spring aop 框架对 BeforeAdvice、AfterAdvice、ThrowsAdvice 三种通知类型的支持实际上是借助适配器模式来实现的，
 * 这样的好处是使得框架允许用户向框架中加入自己想要支持的任何一种通知类型的AdvisorAdapter是一个适配器接口，它定义了自己支持的Advice类型，
 * 并且能把一个Advisor适配成MethodInterceptor（这也是AOP联盟定义的接口）
 *
 * 如果我们想把自己定义的AdvisorAdapter注册到spring aop框架中，怎么办？
 *
 * 把我们自己写好得 AdvisorAdapter 放进 Spring IoC 容器中
 * 配置一个 AdvisorAdapterRegistrationManager，它是一个 BeanPostProcessor，它会检测所有的Bean。
 * 若是AdvisorAdapter类型，就：this.advisorAdapterRegistry.registerAdvisorAdapter((AdvisorAdapter) bean);
 *
 * 一般我们自己并不需要自己去提供此接口的实现(除非你还行适配被的 Advice 进来)，因为 Spring 为我们提供了对应的实现
 *
 * Interface allowing extension to the Spring AOP framework to allow
 * handling of new Advisors and Advice types.
 *
 * <p>Implementing objects can create AOP Alliance Interceptors from
 * custom advice types, enabling these advice types to be used
 * in the Spring AOP framework, which uses interception under the covers.
 *
 * <p>There is no need for most Spring users to implement this interface;
 * do so only if you need to introduce more Advisor or Advice types to Spring.
 *
 * @author Rod Johnson
 */
public interface AdvisorAdapter {

	/**
	 * 以下是它的定义：
	 *    判断此适配器是否支持特定的Advice
	 * Does this adapter understand this advice object? Is it valid to
	 * invoke the {@code getInterceptors} method with an Advisor that
	 * contains this advice as an argument?
	 * @param advice an Advice such as a BeforeAdvice
	 * @return whether this adapter understands the given advice object
	 * @see #getInterceptor(org.springframework.aop.Advisor)
	 * @see org.springframework.aop.BeforeAdvice
	 */
	boolean supportsAdvice(Advice advice);

	/**
	 * 将一个 Advisor 适配成 MethodInterceptor
	 *
	 * Return an AOP Alliance MethodInterceptor exposing the behavior of
	 * the given advice to an interception-based AOP framework.
	 * <p>Don't worry about any Pointcut contained in the Advisor;
	 * the AOP framework will take care of checking the pointcut.
	 * @param advisor the Advisor. The supportsAdvice() method must have
	 * returned true on this object
	 * @return an AOP Alliance interceptor for this Advisor. There's
	 * no need to cache instances for efficiency, as the AOP framework
	 * caches advice chains.
	 */
	MethodInterceptor getInterceptor(Advisor advisor);

}
