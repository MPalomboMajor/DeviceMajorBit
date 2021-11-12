package it.majorbit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.majorbit.DTO.UserDTO;
import it.majorbit.DTO.UserLaptopDTO;
import it.majorbit.DTO.UserRoleDTO;
import it.majorbit.model.Laptop;
import it.majorbit.model.Role;
import it.majorbit.model.User;
import it.majorbit.service.LaptopService;
import it.majorbit.service.RoleService;
import it.majorbit.service.UserService;

@Controller("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private LaptopService laptopService;

	@Autowired
	private RoleService roleService;

	@GetMapping(path = "login")
	public @ResponseBody String login(@RequestParam String email, @RequestParam String password) {

		String msg = "";

		User userLoggato = userService.loginUser(email, password);
		if (userLoggato != null) {
			msg = "Utente loggato con successo!";
		} else {
			msg = "Dati inseriti non trovati";
		}

		return msg;
	}

	@GetMapping(path = "getAllUsersLaptopDTO")
	public @ResponseBody List<UserLaptopDTO> getAllUsersLaptopDTO() {

		return userService.getAllUsersLaptop();
	}

	@GetMapping(path = "getAllUsersRoleDTO")
	public @ResponseBody List<UserRoleDTO> getAllUsersRoleDTO() {

		return userService.getAllUsersRole();
	}
	
	@GetMapping(path = "getAllUsersDTO")
	public @ResponseBody List<UserDTO> getAllUsersDTO(){
		
		return userService.getAllUsersDto();
	}

	@PostMapping(path = "registerUser")
	public @ResponseBody String registerUser(@RequestBody Map<String, Object> params) {

		String msg = "";

		if (params.get("email") != null && params.get("password") != null && params.get("name") != null
				&& params.get("surname") != null && params.get("phoneNumb") != null
				&& params.get("workPlace") != null) {

			String email = (String) params.get("email");
			String password = (String) params.get("password");
			String name = (String) params.get("name");
			String surname = (String) params.get("surname");
			String phoneNumb = (String) params.get("phoneNumb");
			String workPlace = (String) params.get("workPlace");
			if (params.get("serialID") != null) {
				Laptop newLaptop = laptopService.getLaptopById((Integer) params.get("serialID"));
				if (params.get("kind") != null) {
					Role newRole = roleService.getRoleById((String) params.get("kind"));
					User newUser = new User(email, password, name, surname, phoneNumb, workPlace, newLaptop, newRole);
					if (userService.getUserByEmail(email) == null) {
						userService.insertUser(newUser);
					} else {
						msg = "Utente già presente";
						return msg;
					}

				} else {
					msg = "Ruolo non trovato";
					return msg;
				}
			} else {
				msg = "Serial ID non trovato";
				return msg;
			}

		} else {
			msg = "Dati inseriti non corretti";
			return msg;
		}

		msg = "User aggiunto con successo";
		return msg;

	}

	@PutMapping(path = "modifyUser")
	public @ResponseBody String modifyUser(@RequestBody Map<String, Object> params) {

		String msg = "";
		if (params.get("ID") != null) {
			Integer ID = (Integer) params.get("ID");
			if (userService.getUserById(ID) != null) {
				User updatedUser = userService.getUserById(ID);
				if (updatedUser != null && params.get("newName") != null && params.get("newSurname") != null
						&& params.get("newPhoneNumb") != null && params.get("newWorkPlace") != null) {
					updatedUser.setName((String) params.get("newName"));
					updatedUser.setSurname((String) params.get("newSurname"));
					updatedUser.setPhone((String) params.get("newPhoneNumb"));
					updatedUser.setWorkPlace((String) params.get("newWorkPlace"));
					userService.insertUser(updatedUser);

				} else {
					msg = "Inserimento dati fallito";
					return msg;
				}
			} else {
				msg = "User non trovato";
				return msg;
			}

		} else {
			msg = "Serial ID non trovato";
			return msg;
		}
		msg = "User modificato con successo";
		return msg;
	}

	@DeleteMapping(path = "removeUser")
	public @ResponseBody String removeDipendente(@RequestParam Integer ID) {

		String msg = "";

		if (ID != null) {
			userService.deleteUser(ID);
		} else {
			msg = "ID inserito non esistente";
			return msg;
		}

		msg = "User rimosso con successo";
		return msg;

	}

}
