package net.hubs1.com.repository;

import java.util.List;
import java.util.UUID;

import net.hubs1.com.BaseTest;
import net.hubs1.com.domain.Person;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PerTest  extends BaseTest{
	
	@Autowired
	private PerRepository peronRepository;
	
	@Test
	public void testFind(){
		
		List<Person> list = peronRepository.findByNameLike("person1");
		
		System.out.println(list);
	}
	@Test
	public void testFindAll(){
		
		List<Person> list = peronRepository.findAll();
		
		System.out.println(list);
	}
	@Test
	public void testSave(){
		Person data=new Person();
		data.setAge(12);
		data.setId(UUID.randomUUID().toString());
		data.setName("person1");
		data.setSex("男");
		Person save = peronRepository.save(data);
	    System.out.println(save);
		
	}
	@Test
	public void testMain(){
	   String mess="";
	   String[] split = mess.split(",");
	   for (String string : split) {
        System.out.println(string);
	   }
	    
	}

}
