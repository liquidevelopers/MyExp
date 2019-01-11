package com.yaniv.appsserver.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Employee {

	 @Id
	 @GeneratedValue(strategy= GenerationType.IDENTITY)
	 private Long id;
	 
	 @Column(name="EMPLOYEE_NAME")
	 private String name;
	 
	 @Column(name="EMPLOYEE_SALARY")
	 private Long phoneNumer;
	 
	 @Column(name="DEPARTMENT")
	 private String department;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Long getPhoneNumer() {
		return phoneNumer;
	}

	public void setPhoneNumer(Long phoneNumer) {
		this.phoneNumer = phoneNumer;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phoneNumer=" + phoneNumer + ", department=" + department
				+ "]";
	}
	 
}