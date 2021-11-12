package it.majorbit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Laptop {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer serialID;
	@Column
	private String brand;
	@Column
	private String model;
	@Column
	private String description;
	@Column
	private Boolean available;
	@Column
	private Date assignamentDate;
	@Column
	private Integer totDevice;
	@Column
	private Integer numbAvailable;
	@Column
	private Integer numbEmployees;

	public Laptop(String brand, String model, String description, Boolean available, Date assignamentDate,
			Integer totDevice, Integer numbAvailable, Integer numbEmployees) {
		super();
		this.brand = brand;
		this.model = model;
		this.description = description;
		this.available = available;
		this.assignamentDate = assignamentDate;
		this.totDevice = totDevice;
		this.numbAvailable = numbAvailable;
		this.numbEmployees = numbEmployees;
	}

	public Laptop(String brand, String model, String description, Boolean available, Integer totDevice,
			Integer numbAvailable, Integer numbEmployees) {
		super();
		this.brand = brand;
		this.model = model;
		this.description = description;
		this.available = available;
		this.totDevice = totDevice;
		this.numbAvailable = numbAvailable;
		this.numbEmployees = numbEmployees;
	}

	public Laptop() {

	}

	public Integer getSerialID() {
		return serialID;
	}

	public void setSerialID(Integer serialID) {
		this.serialID = serialID;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public Date getAssignamentDate() {
		return assignamentDate;
	}

	public void setAssignamentDate(Date assignamentDate) {
		this.assignamentDate = assignamentDate;
	}

	public Integer getTotDevice() {
		return totDevice;
	}

	public void setTotDevice(Integer totDevice) {
		this.totDevice = totDevice;
	}

	public Integer getNumbAvailable() {
		return numbAvailable;
	}

	public void setNumbAvailable(Integer numbAvailable) {
		this.numbAvailable = numbAvailable;
	}

	public Integer getNumbEmployees() {
		return numbEmployees;
	}

	public void setNumbEmployees(Integer numbEmployees) {
		this.numbEmployees = numbEmployees;
	}

	@Override
	public String toString() {
		return "Laptop [serialID=" + serialID + ", brand=" + brand + ", modello=" + model + ", description="
				+ description + ", available=" + available + ", assignamentDate=" + assignamentDate + ", totDevice="
				+ totDevice + ", numbAvailable=" + numbAvailable + ", numbEmployees=" + numbEmployees + "]";
	}

}
