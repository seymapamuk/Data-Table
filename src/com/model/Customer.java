package com.model;

public class Customer {

	private String name;
	private String surname;
	private int id;
	private String adr;
	private boolean edit;
	
	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public Customer(String n, String sn, int id, String adr) {
		name = n;
		surname = sn;
		this.id = id;
		this.adr = adr;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdr() {
		return adr;
	}

	public void setAdr(String adr) {
		this.adr = adr;
	}
	
}
