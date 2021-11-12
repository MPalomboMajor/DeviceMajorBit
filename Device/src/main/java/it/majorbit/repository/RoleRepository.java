package it.majorbit.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.majorbit.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, String>{

	@Query("SELECT r FROM Role r WHERE r.name = ?1")
	public Role findRoleByName (String name);
	
	
}
