package org.springframework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.component.DemoComponent;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: doudou
 * @since: 2021-10-13
 */
@RestController
public class Controller {

//	@Autowired
//	private MessageService messageService;

	@Autowired
	private DemoComponent demoComponent;

	@PostMapping("/test")
	public String test() {
//		return messageService.getMessage();
		return demoComponent.say();
	}


}
