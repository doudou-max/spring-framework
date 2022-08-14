package com.user.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: doudou
 * @since: 2022-08-11
 */
public class TxMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
		AccountService accountService = (AccountService) applicationContext.getBean("accountService");
		accountService.save();
		applicationContext.close();
	}

}
