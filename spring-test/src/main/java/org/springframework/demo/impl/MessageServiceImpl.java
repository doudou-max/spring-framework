package org.springframework.demo.impl;

import org.springframework.demo.MessageService;
import org.springframework.stereotype.Service;

/**
 * @author: doudou
 * @since: 2021-10-12
 */
@Service
public class MessageServiceImpl implements MessageService {

	public String getMessage() {
		return "hello world";
	}
}