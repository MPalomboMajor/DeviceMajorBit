package it.majorbit.DTO;

import java.util.Date;

public class UserDTO {
	
	private String name;
	private String surname;
	private String email;
	private String phoneNumb;
	private String workPlace;
	private String roleName;
	private Integer rolePriority;
	private String laptopModel;
	private String laptopBrand;
	private String laptopDesc;
	private Date laptopAssignDate;
	
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumb() {
		return phoneNumb;
	}
	public void setPhoneNumb(String phoneNumb) {
		this.phoneNumb = phoneNumb;
	}
	public String getWorkPlace() {
		return workPlace;
	}
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getRolePriority() {
		return rolePriority;
	}
	public void setRolePriority(Integer rolePriority) {
		this.rolePriority = rolePriority;
	}
	public String getLaptopModel() {
		return laptopModel;
	}
	public void setLaptopModel(String laptopModel) {
		this.laptopModel = laptopModel;
	}
	public String getLaptopBrand() {
		return laptopBrand;
	}
	public void setLaptopBrand(String laptopBrand) {
		this.laptopBrand = laptopBrand;
	}
	public String getLaptopDesc() {
		return laptopDesc;
	}
	public void setLaptopDesc(String laptopDesc) {
		this.laptopDesc = laptopDesc;
	}
	public Date getLaptopAssignDate() {
		return laptopAssignDate;
	}
	public void setLaptopAssignDate(Date laptopAssignDate) {
		this.laptopAssignDate = laptopAssignDate;
	}
	
	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", surname=" + surname + ", email=" + email + ", phoneNumb=" + phoneNumb
				+ ", workPlace=" + workPlace + ", roleName=" + roleName + ", rolePriority=" + rolePriority
				+ ", laptopModel=" + laptopModel + ", laptopBrand=" + laptopBrand + ", laptopDesc=" + laptopDesc
				+ ", laptopAssignDate=" + laptopAssignDate + "]";
	}
	

	

}
