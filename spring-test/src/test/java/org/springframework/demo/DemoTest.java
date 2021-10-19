package org.springframework.demo;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author: doudou
 * @since: 2021-10-15
 */
@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml"})
public class DemoTest {

	@Autowired
	private MessageService messageService;

	@Test
	public void testMessage() {
		System.out.println(messageService.getMessage());
	}


}
