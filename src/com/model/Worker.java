package com.model;

public class Worker {
	
	String name;
	String surname;
	int sicil;
	String departman;
	boolean edit;
	//int num;
	String password;
	
	public Worker() {}

	public Worker(String n, String sn, int s, String d) {

		name = n;
		surname = sn;
		sicil = s;
		departman = d;
		
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

	public int getSicil() {
		return sicil;
	}

	public void setSicil(int sicil) {
		this.sicil = sicil;
	}

	public String getDepartman() {
		return departman;
	}

	public void setDepartman(String departman) {
		this.departman = departman;
	}

	public boolean isEdit() {
		return edit;
	}	

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
