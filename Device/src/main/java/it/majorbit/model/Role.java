package it.majorbit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Role {
	
	@Id
	private String kind;
	@Column
	private String name;
	@Column
	private Integer priority;
	
	public Role(String kind, String name, Integer priority) {
		this.kind = kind;
		this.name = name;
		this.priority = priority;
	}
	
	public Role() {
		
	}
	
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "Role [kind=" + kind + ", name=" + name + ", priority=" + priority + "]";
	}
	

}
