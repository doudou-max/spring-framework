package org.springframework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.demo.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: doudou
 * @since: 2021-10-13
 */
@RestController
public class Controller {

	@Autowired
	private MessageService messageService;

	@GetMapping("/test")
	public String test() {
		return messageService.getMessage();
	}


}
