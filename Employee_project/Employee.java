package com.Hibernate.Emp.Employee;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Employee {	//Entity Class or POJO class or Model Class
	@Id
	private int id;
	private String name;
	private double salary;
	private long ph_no;
}
