package com.canddella.inventory.data.entry;

import java.io.Serializable;
import java.time.LocalDate;

public class Customer  implements Serializable{
	
	private int customerID;
	protected String firstName;
	protected String lastName;
	private String email;
	private String phoneNumber;
	public  String sex;
	public LocalDate dateOfBirth;
	public Customer(int customerID, String firstName, String lastName , String sex, String email, String phoneNumber, LocalDate dateOfBirth) {
		super();
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", sex=" + sex + ", dateOfBirth=" + dateOfBirth + "]";
	}
	public int getCustomerID() {
		return customerID;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getSex() {
		return sex;
	}
	public String getFullName() {
		return firstName+lastName;
	}

	
}
