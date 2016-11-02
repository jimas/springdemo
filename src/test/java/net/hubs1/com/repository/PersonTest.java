package net.hubs1.com.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.hubs1.com.BaseTest;
import net.hubs1.com.domain.PersonData;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;

public class PersonTest  extends BaseTest{
	
	@Autowired
	private PersonRepository peronRepository;
	@Autowired
	private MongoTemplate mongoTemplate;
	@Test
	public void testFind(){
		
		List<PersonData> list = peronRepository.findByNameLike("person");
		
		System.out.println(list);
	}
	@Test
	public void testSave(){
		PersonData data=new PersonData();
		data.setAge(12);
		data.setId(UUID.randomUUID().toString());
		data.setName("person1");
		data.setSex("男");
		List<String> address=new ArrayList<String>();
		address.add("上海闵行区");
		address.add("安徽亳州");
        data.setAddress(address);
	    PersonData save = peronRepository.save(data);
	    System.out.println(save);
		
	}
	@Test
	public void testTemplateSave(){
		PersonData data=new PersonData();
		data.setAge(15);
		data.setId(UUID.randomUUID().toString());
		data.setName("person3");
		data.setSex("女");
		mongoTemplate.save(data);
		
	}
	@Test
	public void testTemplateFindAll(){
		Query query=new Query();
		List<PersonData> find = mongoTemplate.find(query, PersonData.class);
		System.out.println(find);
		System.out.println(find.size());
		PersonData findOne = mongoTemplate.findOne(query, PersonData.class);//随机一条
		System.out.println(findOne);
		
	}
	@Test
	public void testTemplateFindMore(){
		Query query=new Query();
		CriteriaDefinition criteriaDefinition=new Criteria("name").is("person3");
		query.addCriteria(criteriaDefinition);
		List<PersonData> find = mongoTemplate.find(query, PersonData.class);
		System.out.println(find);
		System.out.println(find.size());
		PersonData findOne = mongoTemplate.findOne(query, PersonData.class);//随机一条
		System.out.println(findOne);
		
	}
	@Test
	public void testTemplateFindOne(){
//		Criteria criteria = new Criteria("name").is("person1");
		Criteria criteria2 = Criteria.where("name").is("person");
		Query query=new Query(criteria2);
		PersonData findOne = mongoTemplate.findOne(query, PersonData.class);
		System.out.println(findOne);
		
	}

}
