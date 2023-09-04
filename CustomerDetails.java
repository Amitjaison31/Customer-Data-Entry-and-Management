package com.canddella.inventory.data.entry;

import java.util.HashMap;
import java.util.Scanner;

public class CustomerDetails {
	
	 public CustomerDetails(HashMap<Integer, Customer> hashMap) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter the customer id: ");
	        int customerIdFromUser = scanner.nextInt();
	        scanner.nextLine(); // Consume the newline character

	        Customer customer = hashMap.get(customerIdFromUser);
	        if (customer != null) {
	            System.out.println("Customer Name\tCustomer Sex\tCustomer Email\tCustomer Phone Number");
	            System.out.println(customer.getFullName() + "\t\t" + customer.getSex() + "\t\t" + customer.getEmail() + "\t\t" + customer.getPhoneNumber());
	        } else {
	            System.out.println("Customer not found.");
	        }
	    }

}
