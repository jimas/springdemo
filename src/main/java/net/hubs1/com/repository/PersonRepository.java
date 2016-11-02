package net.hubs1.com.repository;

import java.util.List;

import net.hubs1.com.domain.PersonData;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PersonRepository extends  MongoRepository<PersonData,ObjectId> {
	
	public PersonData findByName(String name);
	
	public List<PersonData> findByNameLike(String name);
	

}
