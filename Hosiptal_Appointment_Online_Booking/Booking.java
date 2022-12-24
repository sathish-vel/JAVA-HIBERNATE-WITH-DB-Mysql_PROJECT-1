package com.Hibernate.Hosiptal.Mangement.system.Hospital_Booking;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
public class Booking {
	@Id
	private int id;
	private String name;
	private String date;
	private long phoneNo;
	private String email;
}
