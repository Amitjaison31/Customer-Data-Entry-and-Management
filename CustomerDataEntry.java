package com.canddella.inventory.data.entry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class CustomerDataEntry {

	public static void main(String[] args) {

		HashMap<Integer, Customer> hashMap = new HashMap<>();
		int customerID = 1000;
		int siNumber = 0;
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Enter the Customer data \n");

			System.out.print("Customer First Name: ");
			String customerFirstName = scanner.nextLine();

			System.out.print("Customer Last Name: ");
			String customerLastName = scanner.nextLine();

			System.out.print("Sex: ");
			String customerSex = scanner.nextLine();

			System.out.print("Email: ");
			String customerEmail = scanner.nextLine();

			System.out.print("Phone Number: ");
			String customerPhoneNumber = scanner.nextLine();
			
			System.out.print("Date of Birth: ");
			String dob = scanner.nextLine();
			String pattern = "dd-MM-yyyy";
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
			LocalDate customerDOB = LocalDate.parse(dob, formatter);

			customerID++;
		    
			Customer customer = new Customer(customerID, customerFirstName, customerLastName, customerSex,
					customerEmail, customerPhoneNumber, customerDOB);
			hashMap.put(customerID, customer);
			

			System.out.print("Do you want to continue? (Y/N): ");
			String wanttoContinue = scanner.nextLine();
			if (wanttoContinue.equalsIgnoreCase("n")) {
				for (Integer id : hashMap.keySet()) {
					System.out.println("\nCustomer ID: " + id + "\n" + hashMap.get(id));
				}
				break;
			}
		}

		while (true) {
			
			System.out.println();
			System.out.println("Enter 1 to display the list of customers.");
			System.out.println("Enter 2 to see details of customers.");
			System.out.println("Enter 3 to display total number of customers.");
			System.out.println("Enter 4 to display youngest and eldest customer.");
			System.out.println("Enter 5 to store customer data in a file.");

			System.out.println();
			
		
			System.out.print("Enter the option: ");
			int option = scanner.nextInt();
			scanner.nextLine(); 
			
			Collection<Customer> customerValues = hashMap.values();
			ArrayList<Customer> sortedCustomers = new ArrayList<>(customerValues);
			sortedCustomers.sort(Comparator.comparing(Customer::getDateOfBirth));

			if (option == Options.LIST_OF_ALL_CUSTOMERS) {
				System.out.println();
				System.out.println("Serial Number\tCustomer ID \t Customer Name ");
				System.out.println("------------------------------------------------");
				
				for (Customer customer : sortedCustomers) {
					siNumber++;
					System.out.println(siNumber+"\t\t"+ customer.getCustomerID() +"\t\t"+ customer.getFullName() );
				}
			} else if (option == Options.LIST_OF_CUSTOMER_DETAILS) {
				System.out.print("Enter the customer id: ");
				int customerIdFromUser = scanner.nextInt();
				scanner.nextLine(); // Consume the newline character
				Customer customer = hashMap.get(customerIdFromUser);
				if (customer != null) {
					System.out.println("Customer Name\tCustomer Sex\tCustomer Email\tCustomer Phone Number");
					System.out.println(customer.getFullName()+"\t\t"+customer.getSex()+"\t\t"+ customer.getEmail()+"\t\t"+ customer.getPhoneNumber());
					
				} else {
					System.out.println("Customer not found.");
				}
			} else if (option == Options.CUSTOMERS_COUNT) {
				System.out.println("Total number of customers: " + hashMap.size());
			} else if (option == Options.CUSTOMERS_YOUNGEST) {
				Customer youngestCustomer = sortedCustomers.get(sortedCustomers.size()-1);
				Customer eldestCustomer = sortedCustomers.get(0);
				
				System.out.println("Youngest Customer Name: "+ youngestCustomer.getFullName());
		        System.out.println("Date of Birth: " + youngestCustomer.getDateOfBirth());
		        
		        System.out.println("Eldest Customer Name: "+ eldestCustomer.getFullName());
		        System.out.println("Date of Birth: " + eldestCustomer.getDateOfBirth());
			} else if (option == Options.GENERATE_FILE) {
			    try {
			        FileWriter fileWriter = new FileWriter("Customer_Data.txt");
			        System.out.println("");
			        for (Customer customer : hashMap.values()) {
			            fileWriter.write(customer.getCustomerID() + " , ");
			            fileWriter.write(customer.getFullName() + " , ");
			            fileWriter.write(customer.getSex() + " , ");
			            fileWriter.write(customer.getEmail() + " , ");
			            fileWriter.write(customer.getPhoneNumber() + " , ");
			            fileWriter.write(customer.getDateOfBirth() + ". ");
			            fileWriter.write("\n");
			        }
			        fileWriter.close();
			        System.out.println("Customer data saved to 'Customer_Data.txt'.");
			        try {
			            FileReader fileReader = new FileReader("Customer_Data.txt");
			            BufferedReader bufferedReader = new BufferedReader(fileReader);

			            String line;
			            System.out.println("\nContents of 'Customer_Data.txt':");
			            while ((line = bufferedReader.readLine()) != null) {
			                System.out.println(line);
			            }

			            bufferedReader.close();
			        } catch (IOException e) {
				        System.out.println("An error occurred while saving the data to the file.");
				    }
			    } catch (IOException e) {
			        System.out.println("An error occurred while saving the data to the file.");
			    }
			}

			System.out.print("Do you want to continue? (Y/N): ");
			String wanttoContinuee = scanner.nextLine();
			if (wanttoContinuee.equalsIgnoreCase("N")) {
				break;
			}
		}
		scanner.close();

	}
}