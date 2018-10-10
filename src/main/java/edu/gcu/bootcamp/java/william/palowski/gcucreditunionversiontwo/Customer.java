package edu.gcu.bootcamp.java.william.palowski.gcucreditunionversiontwo;

import java.time.LocalDate;

public class Customer {
	
	private String firstName;
	private String lastName;
	private LocalDate date;
	
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
	
	public Customer(String firstName, String lastName, LocalDate date) {
		this.firstName = firstName;
		this.lastName = lastName;
		date = LocalDate.now();
		this.date = date;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public void createAccounts(Bank bank, Customer customer) {
		Checking checking = new Checking(2500.00, "45676543");
		Saving savings = new Saving(5000.00, "12345678");
		Loan loan = new Loan(10000.00,"9876543");
		bank.displayMenu(checking, savings, loan, customer);
	}
}
