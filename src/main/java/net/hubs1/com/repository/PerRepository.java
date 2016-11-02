package net.hubs1.com.repository;

import java.util.List;

import net.hubs1.com.domain.Person;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface PerRepository extends  MongoRepository<Person,String> {
	
	public Person findByName(String name);
	
	public List<Person> findByNameLike(String name);

}
