package it.majorbit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.majorbit.model.Laptop;

@Repository
public interface LaptopRepository extends CrudRepository<Laptop, Integer> {
	
	
	

}
