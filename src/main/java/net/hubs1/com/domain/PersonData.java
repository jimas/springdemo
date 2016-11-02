package net.hubs1.com.domain;

import java.util.List;

import org.springframework.data.annotation.Id;

public class PersonData {

	@Id
	private String id;
	
	private String name;
	private Integer age;
	private String sex;
	private List<String> address;
	
	
	public List<String> getAddress() {
        return address;
    }
    public void setAddress(List<String> address) {
        this.address = address;
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
        builder.append("PersonData [id=").append(id).append(", name=").append(name).append(", age=").append(age).append(", sex=").append(sex)
                .append(", address=").append(address).append("]");
        return builder.toString();
    }
	
	
	
}
