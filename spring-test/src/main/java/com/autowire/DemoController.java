package com.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author: doudou
 * @since: 2022-10-20
 */
@Controller
public class DemoController {

	@Autowired
	private DemoService demoService;

	public String demo() {
		return demoService.demo();
	}

}
