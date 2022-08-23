/*
 * Copyright 2002-2018 the original author or authors.
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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * 需要说明的 cglib 包里也存在一个 MethodInterceptor，它的主要作用是CGLIB内部使用，
 * 一般是和Enhancer一起来使用而创建一个动态代理对象。
 *
 * 而本处我们讲到的 org.aopalliance.intercept.MethodInterceptor，那些 @AspectJ 定义的通知们(增强器们)，
 * 或者是自己实现的 MethodBeforeAdvice、AfterReturningAdvice…(总是都是org.aopalliance.aop.Advice一个通知器)，
 * 最终都会被包装成一个 org.aopalliance.intercept.MethodInterceptor，最终交给 MethodInvocation
 * (其子类ReflectiveMethodInvocation)去执行，它会把你所有的增强器都给执行了，这就是我们面向切面编程的核心思路过程。
 *
 * Intercepts calls on an interface on its way to the target. These
 * are nested "on top" of the target.
 *
 * <p>The user should implement the {@link #invoke(MethodInvocation)}
 * method to modify the original behavior. E.g. the following class
 * implements a tracing interceptor (traces all the calls on the
 * intercepted method(s)):
 *
 * <pre class=code>
 * class TracingInterceptor implements MethodInterceptor {
 *   Object invoke(MethodInvocation i) throws Throwable {
 *     System.out.println("method "+i.getMethod()+" is called on "+
 *                        i.getThis()+" with args "+i.getArguments());
 *     Object ret=i.proceed();
 *     System.out.println("method "+i.getMethod()+" returns "+ret);
 *     return ret;
 *   }
 * }
 * </pre>
 *
 * 从名字里都能看出来，它是通过拦截方法的执行来实现通知得效果的
 *
 * @author Rod Johnson
 */
@FunctionalInterface
public interface MethodInterceptor extends Interceptor {

	/**
	 * 可以在此方法里，在方法执行之前、之后做对应的处理。
	 * 需要执行的时候，调用 invocation.proceed() 方法即可
	 *
	 * Implement this method to perform extra treatments before and
	 * after the invocation. Polite implementations would certainly
	 * like to invoke {@link Joinpoint#proceed()}.
	 * @param invocation the method invocation joinpoint
	 * @return the result of the call to {@link Joinpoint#proceed()};
	 * might be intercepted by the interceptor
	 * @throws Throwable if the interceptors or the target object
	 * throws an exception
	 */
	@Nullable
	Object invoke(@Nonnull MethodInvocation invocation) throws Throwable;

}
