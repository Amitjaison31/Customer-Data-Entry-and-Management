package com.canddella.inventory.data.entry;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class StoreCustomerData {
	
	 public StoreCustomerData(HashMap<Integer, Customer> hashMap) {
	        try {
	            FileWriter fileWriter = new FileWriter("Customer_Data.txt");
	            for (Customer customer : hashMap.values()) {
	                fileWriter.write(customer.getCustomerID() + " , ");
	                // ... (write other customer details)
	                fileWriter.write("\n");
	            }
	            fileWriter.close();
	            System.out.println("Customer data saved to 'Customer_Data.txt'.");
	        } catch (IOException e) {
	            System.out.println("An error occurred while saving the data to the file.");
	        }
	    }

}
