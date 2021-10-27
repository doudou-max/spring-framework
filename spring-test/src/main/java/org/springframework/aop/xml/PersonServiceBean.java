package org.springframework.aop.xml;

/**
 * @author: doudou
 * @since: 2021-10-27
 */
public class PersonServiceBean implements PersonService {

	public PersonServiceBean() {

	}

	@Override
	public void save(String name) {
		System.out.println("save()->>" + name);
		//throw new RuntimeException(">>----自定义异常----<<");
	}

	@Override
	public String getResult() {
		return "getResult()==>>返回结果";
	}

}
