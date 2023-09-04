package com.canddella.inventory.data.entry;

import java.util.ArrayList;

public class YoungestEldestCustomer {
	
	  public YoungestEldestCustomer(ArrayList<Customer> customers) {
	        Customer youngestCustomer = customers.get(customers.size() - 1);
	        Customer eldestCustomer = customers.get(0);

	        System.out.println("Youngest Customer Name: " + youngestCustomer.getFullName());
	        System.out.println("Date of Birth: " + youngestCustomer.getDateOfBirth());

	        System.out.println("Eldest Customer Name: " + eldestCustomer.getFullName());
	        System.out.println("Date of Birth: " + eldestCustomer.getDateOfBirth());
	    }

}
