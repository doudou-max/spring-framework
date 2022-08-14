package com.ww;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: doudou
 * @since: 2022-08-07
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.ww")
public class Wconfig {
}
