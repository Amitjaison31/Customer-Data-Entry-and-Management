package com.canddella.inventory.data.entry;

import java.util.ArrayList;

public class DisplayCustomers {
	
	
	
	 public DisplayCustomers(ArrayList<Customer> customers) {
	        System.out.println("\nSerial Number\tCustomer ID \t Customer Name ");
	        System.out.println("------------------------------------------------");
	        
	        int siNumber = 0;
	        for (Customer customer : customers) {
	            siNumber++;
	            System.out.println(siNumber + "\t\t" + customer.getCustomerID() + "\t\t" + customer.getFullName());
	        }
	    }

}
