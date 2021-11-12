package it.majorbit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class User {
	
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ID;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String name;
	@Column
	private String surname;
	@Column
	private String phoneNumb;
	@Column
	private String workPlace;
	@OneToOne
	@JoinColumn
	private Laptop laptop;
	@OneToOne
	@JoinColumn
	private Role role;
	
	public User(String email, String password, String name, String surname, String phoneNumb, String workPlace, Laptop laptop, Role role) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.phoneNumb = phoneNumb;
		this.workPlace = workPlace;
		this.laptop = laptop;
		this.role = role;
	}
	
	public User() {
		super();
	}
	
	public Integer getID() {
		return ID;
	}
	
	public void setID(Integer ID){
		this.ID = ID;
	}
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

	public String getPhone() {
		return phoneNumb;
	}

	public void setPhone(String phoneNumb) {
		this.phoneNumb = phoneNumb;
	}

	public String getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}
	
	public Laptop getLaptop() {
		return laptop;
	}
	
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [ID=" + ID + ", email=" + email + ", name=" + name + ", surname=" + surname + ", phoneNumb="
				+ phoneNumb + ", workPlace=" + workPlace + ", laptop=" + laptop + "]";
	}


	


	

	
	
	
	

}
