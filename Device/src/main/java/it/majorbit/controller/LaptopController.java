package it.majorbit.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import it.majorbit.model.Laptop;
import it.majorbit.service.LaptopService;

@Controller(value = "laptop")
public class LaptopController {

	@Autowired
	private LaptopService laptopService;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@GetMapping(path = "getAllLaptop")
	public List<Laptop> getAllLaptop() {

		List<Laptop> listaLaptop = laptopService.readAllLaptop();
		return listaLaptop;
	}
	

	@PostMapping(path = "registerLaptop")
	public @ResponseBody String registerLaptop(@RequestBody Map<String, Object> params) {

		String msg = "";
		Laptop newLaptop = new Laptop();

		if (params.get("serialID") != null && params.get("brand") != null && params.get("model") != null
				&& params.get("description") != null && params.get("availability") != null
				&& params.get("dateAssignement") != null && params.get("totDevice") != null
				&& params.get("numbAvailable") != null && params.get("numbEmployees") != null) {

			Integer serialID = ((Integer) params.get("serialID"));
			newLaptop.setBrand((String) params.get("brand"));
			newLaptop.setModel((String) params.get("model"));
			newLaptop.setDescription((String) params.get("description"));
			newLaptop.setAvailable((Boolean) params.get("availability"));
			Date assignamentDate;
			try {
				assignamentDate = sdf.parse((String) params.get("dateAssignement"));
				newLaptop.setAssignamentDate(assignamentDate);
				System.out.println(assignamentDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			newLaptop.setTotDevice((Integer) params.get("totDevice"));
			newLaptop.setNumbAvailable((Integer) params.get("numbAvailable"));
			newLaptop.setNumbEmployees((Integer) params.get("numbEmployees"));
			if (laptopService.getLaptopById(serialID) == null) {
				laptopService.insertLaptop(newLaptop);
			} else {
				msg = "Laptop già registrato";
				return msg;
			}

		} else {
			msg = "Dati inseriti non corretti";
			return msg;
		}
		msg = "Laptop inserito con successo";
		return msg;


	}

	@PutMapping(path = "modifyLaptop")
	public @ResponseBody String modifyLaptop(@RequestBody Map<String, Object> params) {

		String msg = "";

		if (params.get("serialID") != null) {
			Integer serialID = (Integer) params.get("serialID");
			Laptop newLaptop = laptopService.getLaptopById(serialID);
			if (newLaptop != null) {
				newLaptop.setBrand((String) params.get("newBrand"));
				newLaptop.setModel((String) params.get("newModel"));
				newLaptop.setDescription((String) params.get("newDesc"));
				newLaptop.setAvailable((Boolean) params.get("newAvailability"));
				try {
					newLaptop.setAssignamentDate(sdf.parse((String) params.get("newAssignament")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				newLaptop.setTotDevice((Integer) params.get("newTot"));
				newLaptop.setNumbAvailable((Integer) params.get("newNumbAva"));
				newLaptop.setNumbEmployees((Integer) params.get("newNumbEmp"));
				laptopService.insertLaptop(newLaptop);
			} else {
				msg = "Serial ID non trovato";
				return msg;
			}
		} else {
			msg = "Dati inseriti non corretti";
			return msg;
		}

		msg = "Laptop modificato con successo";
		return msg;
	}

	@DeleteMapping(path = "removeLaptop")
	public @ResponseBody String removeLaptop(@RequestParam Integer serialID) {

		String msg = "";
		if (serialID != null) {
			laptopService.deleteLaptop(serialID);
		} else {
			msg = "Serial ID non trovato";
			return msg;
		}

		msg = "Laptop rimosso con successo";
		return msg;

	}
}
