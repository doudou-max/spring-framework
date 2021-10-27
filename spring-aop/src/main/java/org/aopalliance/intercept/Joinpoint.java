/*
 * Copyright 2002-2016 the original author or authors.
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

package org.aopalliance.intercept;

import java.lang.reflect.AccessibleObject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * 首先需要注意的是，一般我们会接触到两个 Joinpoint
 *
 * org.aspectj.lang.JoinPoint：该对象封装 springAop 中切面方法的信息，在切面方法中添加 JoinPoint 参数，可以很方便的获得更多信息
 * (一般用于 @Aspect 标注的切面的方法入参里)，它的 api 很多，常用的有下面几个：
 * 		1. Signature getSignature(); ：封装了署名信息的对象,在该对象中可以获取到目标方法名,所属类的Class等信息
 * 		2. Object[] getArgs();：传入目标方法的参数们
 * 		3. Object getTarget();：被代理的对象（目标对象）
 * 		4. Object getThis();：该代理对象
 *
 * 备注：ProceedingJoinPoint 对象是 JoinPoint 的子接口，该对象只用在 @Around 的切面方法中
 *
 * This interface represents a generic runtime joinpoint (in the AOP
 * terminology).
 *
 * <p>A runtime joinpoint is an <i>event</i> that occurs on a static
 * joinpoint (i.e. a location in a the program). For instance, an
 * invocation is the runtime joinpoint on a method (static joinpoint).
 * The static part of a given joinpoint can be generically retrieved
 * using the {@link #getStaticPart()} method.
 *
 * <p>In the context of an interception framework, a runtime joinpoint
 * is then the reification of an access to an accessible object (a
 * method, a constructor, a field), i.e. the static part of the
 * joinpoint. It is passed to the interceptors that are installed on
 * the static joinpoint.
 *
 * 此接口表示运行时的连接点 (aop术语)  (和 aspectj里的连接点意思有点像)
 *
 * @author Rod Johnson
 * @see Interceptor
 */
public interface Joinpoint {

	/**
	 * 执行此拦截点，并进入到下一个连接点
	 *
	 * Proceed to the next interceptor in the chain.
	 * <p>The implementation and the semantics of this method depends
	 * on the actual joinpoint type (see the children interfaces).
	 * @return see the children interfaces' proceed definition
	 * @throws Throwable if the joinpoint throws an exception
	 */
	@Nullable
	Object proceed() throws Throwable;

	/**
	 * 返回保存当前连接点静态部分[的对象]，这里一般指的target
	 *
	 * Return the object that holds the current joinpoint's static part.
	 * <p>For instance, the target object for an invocation.
	 * @return the object (can be null if the accessible object is static)
	 */
	@Nullable
	Object getThis();

	/**
	 * 返回此静态连接点，一般就为当前的 Method (至少目前的唯一实现是MethodInvocation,所以连接点得静态部分肯定就是本方法喽)
	 *
	 * Return the static part of this joinpoint.
	 * <p>The static part is an accessible object on which a chain of
	 * interceptors are installed.
	 */
	@Nonnull
	AccessibleObject getStaticPart();

}
