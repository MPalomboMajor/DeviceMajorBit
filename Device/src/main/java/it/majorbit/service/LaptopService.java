package it.majorbit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.majorbit.model.Laptop;
import it.majorbit.repository.LaptopRepository;

@Service
public class LaptopService {
	
	@Autowired
	private LaptopRepository laptopRepo;
	
	public void insertLaptop(Laptop laptop) {
		 laptopRepo.save(laptop);
	}
	
	public Laptop getLaptopById(Integer serialID) {
		
		Laptop laptop = laptopRepo.findById(serialID).orElse(null);
		return laptop;
	}
	
	public void deleteLaptop(Integer serialID) {
		
		laptopRepo.deleteById(serialID);
		
	}
	
	
	public List<Laptop> readAllLaptop(){
		
		return (List<Laptop>) laptopRepo.findAll();
	}
	
	

}
