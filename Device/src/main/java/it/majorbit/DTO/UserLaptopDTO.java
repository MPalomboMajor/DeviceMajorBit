package it.majorbit.DTO;

public class UserLaptopDTO {
	

	private String email;
	private String name;
	private String surname;
	private String phoneNumb;
	private String brand;
	private String model;
	
	

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPhoneNumb() {
		return phoneNumb;
	}
	public void setPhoneNumb(String phoneNumb) {
		this.phoneNumb = phoneNumb;
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
	@Override
	public String toString() {
		return "UserLaptopDTO [email=" + email + ", name=" + name + ", surname=" + surname + ", phoneNumb=" + phoneNumb
				+ ", brand=" + brand + ", model=" + model + "]";
	}

	
	
	

}
