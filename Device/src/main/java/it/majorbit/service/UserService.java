package it.majorbit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.majorbit.DTO.UserDTO;
import it.majorbit.DTO.UserLaptopDTO;
import it.majorbit.DTO.UserRoleDTO;
import it.majorbit.model.User;
import it.majorbit.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void insertUser(User user) {
		
		userRepository.save(user);
	}
	
	public User getUserById(Integer ID) {
		
		User choosenUser = userRepository.findById(ID).orElse(null);
		return choosenUser;
		
	}
	
	public User getUserByEmail(String email) {
		
		User choosenUser = userRepository.findUserByEmail(email);
		if(choosenUser != null) {
			return choosenUser;
		}else {
			return null;
		}

	}
	
	public User loginUser(String email, String password) {
		
		User userLoggato = userRepository.loginUser(email, password);
		if(userLoggato != null) {
			return userLoggato;
		}else {
			return null;
		}
	}
	
	public List<User> getAllUsers(){
		
		return (List<User>) userRepository.findAll();
	}
	
	public void deleteUser(Integer ID) {
		
		userRepository.deleteById(ID);
	}
	
	public List<UserDTO> getAllUsersDto(){
		
		return ((List<User>) userRepository.findAll())
				.stream()
				.map(this::usersToDto)
				.collect(Collectors.toList());
	}
	
	private UserDTO usersToDto(User user) {
		
		UserDTO dto = new UserDTO();
		
		dto.setName(user.getName());
		dto.setSurname(user.getSurname());
		dto.setEmail(user.getEmail());
		dto.setPhoneNumb(user.getPhone());
		dto.setWorkPlace(user.getWorkPlace());
		dto.setRoleName(user.getRole().getName());
		dto.setRolePriority(user.getRole().getPriority());
		dto.setLaptopModel(user.getLaptop().getModel());
		dto.setLaptopBrand(user.getLaptop().getBrand());
		dto.setLaptopDesc(user.getLaptop().getDescription());
		dto.setLaptopAssignDate(user.getLaptop().getAssignamentDate());
		
		return dto;
	}

	
	public List<UserRoleDTO> getAllUsersRole(){
		
		return ((List<User>) userRepository.findAll())
				.stream()
				.map(this::usersRoleToDto)
				.collect(Collectors.toList());
	}
	
	private UserRoleDTO usersRoleToDto(User user) {
		
		UserRoleDTO dto = new UserRoleDTO();
		
		dto.setName(user.getName());
		dto.setSurname(user.getSurname());
		dto.setKind(user.getRole().getKind());
		dto.setPriority(user.getRole().getPriority());
		
		return dto;
	}
	
	public List<UserLaptopDTO> getAllUsersLaptop(){
		
		return ((List<User>) userRepository.findAll())
				.stream()
				.map(this::usersLaptopToDto)
				.collect(Collectors.toList());
	}
	
	private UserLaptopDTO usersLaptopToDto(User user) {
		
		UserLaptopDTO dto = new UserLaptopDTO();
		
		dto.setEmail(user.getEmail());
		dto.setName(user.getName());
		dto.setSurname(user.getSurname());
		dto.setPhoneNumb(user.getPhone());
		dto.setBrand(user.getLaptop().getBrand());
		dto.setModel(user.getLaptop().getModel());
		
		return dto;
	}
	

	

}
