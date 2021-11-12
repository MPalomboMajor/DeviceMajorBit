package it.majorbit.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.majorbit.model.Role;
import it.majorbit.service.RoleService;

@Controller(value = "ruolo")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@PostMapping(path = "registerRole")
	public @ResponseBody String registerRuolo(@RequestBody Map<String, Object> params) {

		String msg = "";

		if (params.get("kind") != null && params.get("name") != null && params.get("priority") != null) {
			String kind = (String) params.get("kind");
			String name = (String) params.get("name");
			Integer priority = (Integer) params.get("priority");
			Role newRole = new Role(kind, name, priority);
			if (roleService.getRoleById(kind) == null) {
				roleService.insertRole(newRole);
			} else {
				msg = "Ruolo già presente";
				return msg;
			}

		} else {
			msg = "Dati inseriti non corretti";
			return msg;
		}

		msg = "Ruolo inserito con successo";
		return msg;
	}

	@PutMapping(path = "modifyRole")
	public @ResponseBody String modifyRuolo(@RequestBody Map<String, Object> params) {

		String msg = "";

		if (params.get("name") != null) {
			if ((params.get("name") != "Impiegato" || params.get("name") != "Administrator"
					|| params.get("name") != "Operator")) {
				String name = (String) params.get("name");
				Role newRole = roleService.getRoleByName(name);
				if (params.get("newName") != null && params.get("newPriority") != null) {
					newRole.setName((String) params.get("newName"));
					newRole.setPriority((Integer) params.get("newPriority"));
					roleService.insertRole(newRole);
				} else {
					msg = "Dati inseriti non corretti";
					return msg;

				}
			} else {
				msg = "Ruolo inserito non trovato, non disponibile";
				return msg;
			}
		} else {
			msg = "Ruolo inserito non trovato, non disponibile";
			return msg;
		}

		msg = "Ruolo modificato con successo";
		return msg;
	}

	@DeleteMapping(path = "removeRole")
	public @ResponseBody String removeRole(@RequestParam String kind) {

		String msg = "";
		if (kind != null && !kind.isEmpty()) {
			roleService.deleteRole(kind);
		} else {
			msg = "Tipo inserito non trovato";
			return msg;
		}

		msg = "Ruolo rimosso con successo";
		return msg;

	}

}
