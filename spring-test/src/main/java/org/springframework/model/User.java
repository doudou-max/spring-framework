package org.springframework.model;

import org.springframework.beans.factory.BeanNameAware;

/**
 * @author: doudou
 * @since: 2021-10-14
 */
public class User implements BeanNameAware {

	private String id;

	private String name;

	public User() {
	}

	public User(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setBeanName(String name) {
		this.id=name;
	}

	@Override
	public String toString() {
		return "User{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				'}';
	}

	public String say() {
		return  "demo configuration";
	}
}
