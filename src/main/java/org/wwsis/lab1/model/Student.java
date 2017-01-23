package org.wwsis.lab1.model;

public class Student {

	private String firstName;
	private String lastName;
	private int age;
	private String email;
	private String address;
	
	public int getAge() {
		return age;
	}

	public void setAge(int wiek) {
		this.age = wiek;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
