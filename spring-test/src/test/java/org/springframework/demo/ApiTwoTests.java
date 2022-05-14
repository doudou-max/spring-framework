package org.springframework.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author: doudou
 * @since: 2021-11-04
 */
@RunWith(JUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:application.xml"})
public class ApiTwoTests {

	@Autowired
	public WebApplicationContext wac;

	public MockMvc mockMvc;

	public MockHttpSession session;

	@Before
	public void before() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void testGetSequence() {
		try {
			MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/test"))
					.andExpect(MockMvcResultMatchers.status().is(200))
					.andDo(MockMvcResultHandlers.print())
					.andReturn();
			int status = mvcResult.getResponse().getStatus();
			System.out.println("请求状态码：" + status);
			String result = mvcResult.getResponse().getContentAsString();
			System.out.println("接口返回结果：" + result);
//			JSONObject resultObj = JSON.parseObject(result);
			// 判断接口返回json中success字段是否为true
//			Assert.assertTrue(resultObj.getBooleanValue("success"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
