package it.majorbit.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.majorbit.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	@Query("SELECT u FROM User u WHERE u.email = ?1")
	public User findUserByEmail(String email);
	

	@Query("SELECT u FROM User u WHERE u.email = ?1 AND u.password = ?2")
	public User loginUser(String email, String password);
}
