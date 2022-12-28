package com.myDemoProject.HibernateDemo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Laptop {
	@Id
	private int id;
	private String lapName;
	private int lapRam;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLapName() {
		return lapName;
	}

	public void setLapName(String lapName) {
		this.lapName = lapName;
	}

	public int getLapRam() {
		return lapRam;
	}

	public void setLapRam(int lapRam) {
		this.lapRam = lapRam;
	}

}
