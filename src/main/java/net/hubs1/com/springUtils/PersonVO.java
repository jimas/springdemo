package net.hubs1.com.springUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PersonVO implements Serializable {

    private static final long serialVersionUID = 399173899087084763L;
    
    private String name;
    private List<String> addressList;
    private Integer money;
    private int age;
    private Date birthday;
    private Boolean married;
    private boolean gender;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<String> getAddressList() {
        return addressList;
    }
    public void setAddressList(List<String> addressList) {
        this.addressList = addressList;
    }
    public Integer getMoney() {
        return money;
    }
    public void setMoney(Integer money) {
        this.money = money;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public Boolean getMarried() {
        return married;
    }
    public void setMarried(Boolean married) {
        this.married = married;
    }
    public boolean isGender() {
        return gender;
    }
    public void setGender(boolean gender) {
        this.gender = gender;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PersonVO [name=").append(name).append(", addressList=").append(addressList).append(", money=").append(money).append(", age=")
                .append(age).append(", birthday=").append(birthday).append(", married=").append(married).append(", gender=").append(gender)
                .append("]");
        return builder.toString();
    }
    
    

}
