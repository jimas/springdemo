package net.hubs1.com.domain;

import org.springframework.data.annotation.Id;

public class Person {

	@Id
	private String id;
	
	private String name;
	private Integer age;
	private String sex;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PersonData [");
		if (id != null)
			builder.append("id=").append(id).append(", ");
		if (name != null)
			builder.append("name=").append(name).append(", ");
		if (age != null)
			builder.append("age=").append(age).append(", ");
		if (sex != null)
			builder.append("sex=").append(sex);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
