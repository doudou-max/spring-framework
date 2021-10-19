package org.springframework.demo.impl;

import org.springframework.demo.MessageService;

/**
 * @author: doudou
 * @since: 2021-10-12
 */
public class MessageServiceImpl implements MessageService {

	public String getMessage() {
		return "hello world";
	}
}