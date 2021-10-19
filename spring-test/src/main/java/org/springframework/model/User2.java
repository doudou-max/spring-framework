package org.springframework.model;

/**
 * @author: doudou
 * @since: 2021-10-14
 */
public class User2 {

	private String id;

	private String name;

	public User2() {
	}

	public User2(String id, String name) {
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
	public String toString() {
		return "User{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				'}';
	}

}
