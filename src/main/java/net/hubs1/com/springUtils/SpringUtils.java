package net.hubs1.com.springUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.BeanUtils;

public class SpringUtils {
    
    public static void main(String[] args) {
        PersonDomain personDomain = new PersonDomain();
        List<String> addressList=new ArrayList<String>();
        addressList.add("上海市");
        addressList.add("合肥市");
        personDomain.setAddressList(addressList);
        personDomain.setAge(20);
        personDomain.setBirthday(new  Date());
        personDomain.setGender(true);
        personDomain.setMarried(false);
        personDomain.setMoney(200);
        personDomain.setName("jimas");
        PersonVO springPerson = new PersonVO();
        PersonVO apachePerson = new PersonVO();
        copyProperties(personDomain, springPerson);
        copyProperties(personDomain,apachePerson);
        System.out.println(springPerson);
        System.out.println(apachePerson);
    }

    public static void beanUtils(Object source,Object target){
        BeanUtils.copyProperties(source, target);
    }
    public static void copyProperties(Object orig,Object dest){
        try {
            PropertyUtils.copyProperties(dest, orig);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    
    
}
