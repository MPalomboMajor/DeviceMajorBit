package it.majorbit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.majorbit.model.Role;
import it.majorbit.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepo;

	public void insertRole(Role role) {
		roleRepo.save(role);
	}

	public Role getRoleById(String kind) {

		Role role = roleRepo.findById(kind).orElse(null);
		return role;
	}
	
	public Role getRoleByName(String name) {
		
		if(name != null && !name.isEmpty()) {
			Role role = roleRepo.findRoleByName(name);
			return role;
		}
		return null;

		

	}

	public List<Role> getAllRoles() {

		return (List<Role>) roleRepo.findAll();

	}

	public void deleteRole(String kind) {

		roleRepo.deleteById(kind);

	}
}
