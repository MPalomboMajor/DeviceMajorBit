package it.majorbit.DTO;

public class UserRoleDTO {
	
	private String name;
	private String surname;
	private String kind;
	private Integer priority;
	
	
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
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	@Override
	public String toString() {
		return "UserRoleDTO [name=" + name + ", surname=" + surname + ", kind=" + kind + ", priority=" + priority + "]";
	}
	
	

}
