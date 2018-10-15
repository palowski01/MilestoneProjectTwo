package edu.gcu.bootcamp.java.william.palowski.gcucreditunionversiontwo;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

import edu.gcu.bootcamp.java.william.palowski.gcucreditunionversiontwo.Bank;
import edu.gcu.bootcamp.java.william.palowski.gcucreditunionversiontwo.Checking;
import edu.gcu.bootcamp.java.william.palowski.gcucreditunionversiontwo.Saving;

public class Bank {

	static Scanner input = new Scanner(System.in);
	private String name;
	
	public static void main(String[] args) {
		Customer customer;
		Bank gcu = new Bank("GCU Credit Union");
		customer = gcu.createCustomer();
		customer.createAccounts(gcu, customer);
//		Checking billChecking = new Checking(5000.00, "991773");
//		Saving billSaving = new Saving(5000.00, "191923");
//		Loan billLoan = new Loan(10000.00, "9876543");
//		billChecking.setOverDraft(45.00);
//		billSaving.setMinBalance(200);
//		billSaving.setAnnualInterestRate(.03);
//		billSaving.setServiceFee(25);
//		gcu.displayMenu(billChecking, billSaving, billLoan);
		
	}
	
	public Bank(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	private Customer createCustomer() {
		String fName = "James";
		String lName = "Bond";
		LocalDate date = LocalDate.now();
		
		System.out.println("Welcome to " + this.name);
		System.out.println("You must become a member to use our services");
		System.out.println("Mr. " + lName + " you have already signed up as a memeber");
		System.out.println("Thank you for becoming a member of " + this.name);
		Customer newCustomer = new Customer(fName, lName, date);
		return newCustomer;
	}
	
	public void displayMenu(Checking checking, Saving saving, Loan loan, Customer customer) {
		int option = 0;
		do {
			System.out.println("=========================================");
			System.out.println("               MAIN MENU                 ");
			System.out.println("            " + this.name + "              ");
			System.out.println("        Today's date is " + customer.getDate() + "     ");
			System.out.println("=========================================");
			System.out.println("Pick an option:");
			System.out.println("-----------------------------------------");
			System.out.println("1: : Deposit to Checking");
			System.out.println("2: : Deposit to Savings");
			System.out.println("3: : Write a Check");
			System.out.println("4: : Withdraw from Savings");
			System.out.println("5: : Pay on Loan");
			System.out.println("6: : Get Account Balances");
			System.out.println("7: : Calculate End of Month"); //calculate service fee and interest earned
			System.out.println("8: : Check Current Statement");
			System.out.println("-----------------------------------------");
			System.out.println("9: : Exit");
			option = input.nextInt();
			System.out.println();
			this.actionMenu(option, checking, saving, loan, customer);
		}while(option != 9);
		
		
	}
	
	private void actionMenu(int opt, Checking checking, Saving saving, Loan loan, Customer customer) {
		switch(opt) {
			case 1: this.displayDepositChecking(checking);
				break;
			case 2: this.displayDepositSaving(saving);
				break;
			case 3: this.displayWithdrawChecking(checking);
				break;
			case 4: this.displayWithdrawSavings(saving);
				break;
			case 5: this.displayLoanPayment(loan);
				break;
			case 6: this.displayBalanceScreen(checking, saving, loan);
				break;
			case 7: this.doEndOfMonth(checking, saving, loan, customer);
				break;
			case 8: Account.displayStatement();
				break;
			case 9: this.displayExitScreen();
				break;
		}
	}
	
	private void doEndOfMonth(Checking checking, Saving saving, Loan loan, Customer customer) {
		double interestOnLoan = loan.balance * loan.getInterestRate();
		double interestRatePerMonth = (saving.getAnnualInterestRate()/12);
		double interestOnAccount = saving.balance * interestRatePerMonth;
		LocalDate date = LocalDate.now();
		
		System.out.println("Calculate end of month items");
		System.out.printf("Savings account #%s has a balance of $%.2f", saving.account, saving.balance);
		
		if (saving.balance < saving.getMinBalance()) {
			System.out.printf("Your account is below the minimum balance of $%.2f", saving.getMinBalance());
			System.out.printf("You are being charged a service fee of $%.2f", saving.getServiceFee());
			double balanceMinusServiceFee = saving.getBalance() - saving.getServiceFee();
			System.out.printf("Your new balance is $%.2f", balanceMinusServiceFee);
			saving.setBalance(balanceMinusServiceFee +(balanceMinusServiceFee * interestRatePerMonth));
		}
		else {
			saving.setBalance(saving.getBalance() + (saving.getBalance() * interestRatePerMonth));
		}
		System.out.println();
		System.out.printf("Your savings account balance plus $%.2f of interest for the month is $%.2f", interestOnAccount, saving.getBalance());
		System.out.println();
		System.out.printf("Checking account #%s has a balance of $%.2f", checking.account, checking.balance);
		System.out.println();
		if (checking.balance < 0) {
			System.out.printf("Your account is below 0. you were assessed a $%.2f overdraft fee.\n", checking.getOverDraft());
		}
		
		//The line below is for testing end of month purposes only
		//comment out this line if you want the program to run normal
//		date = date.with(TemporalAdjusters.lastDayOfMonth()); 
//		if ((date == date.with(TemporalAdjusters.lastDayOfMonth())) && (loan.balance == loan.balance))
		
		if (loan.balance == loan.getNewLoanBalance()){
			loan.setBalance((interestOnLoan/12) + loan.getLateFee() + loan.balance);
			System.out.printf("You did not make a payment on your Loan account #%s.\n", loan.account);
			System.out.printf("You were charged a late fee of $%.2f...\n", loan.getLateFee());
			System.out.printf("Your Loan account balance is $%.2f...", loan.balance);
			System.out.println();
		}
		else {
			loan.setBalance((interestOnLoan/12) + loan.balance);
			System.out.printf("Your Loan account #%s has a balance of $%.2f.", loan.account, loan.balance);
			loan.setNewLoanBalance(loan.balance);
		}
		System.out.println("\n\n\n");
		Account.displayStatement();
		Account.clearStatement();
	}
	
	private void displayExitScreen() {
		System.out.println("=========================================");
		System.out.println("      THANK YOU FOR BANKING WITH         ");
		System.out.println("            " + this.name + "              ");
		System.out.println("=========================================");
	}
	
	private void displayBalanceScreen(Checking checking, Saving saving, Loan loan) {
		
		System.out.printf("For checking account #%s your balance is $%.2f", checking.account, checking.balance);
		System.out.println();
		System.out.printf("For savings account #%s your balance is $%.2f", saving.account, saving.balance);
		System.out.println();
		System.out.printf("For your loan account #%s your balance is $%.2f", loan.account, loan.balance);
		System.out.println();
	}
	
	private void displayWithdrawSavings(Saving saving) {

		System.out.println("WITHDRAW FROM SAVINGS ACCOUNT #" + saving.account);
		System.out.printf("You will have a $%.2f service fee if balance is below $%.2f at the end of the month", 
				saving.getServiceFee(), saving.getMinBalance());
		System.out.println();
		System.out.println("Your savings account balance is $" + saving.balance);
		System.out.print("How much to you want to withdraw: $");
		double withdraw = input.nextDouble();
		System.out.println();
		saving.doWithdraw(withdraw);
		saving.addToStatement(withdraw, "withdraw", "Savings");
	}
	
	private void displayWithdrawChecking(Checking checking) {
		
		System.out.println("WITHDRAW FROM CHECKING ACCOUNT #" + checking.account);
		System.out.println("Your checking account balance is $" + checking.balance);
		System.out.printf("You will have a $%.2f overdraft fee if check amount is greater than balance", checking.getOverDraft());
		System.out.println();
		System.out.print("How much to withdraw: $");
		double withdraw = input.nextDouble();
		System.out.println();
		checking.doWithdraw(withdraw);
		if (checking.getBalance() < 0) {
			System.out.printf("OVERDRAFT NOTICE: $%.2f fee assessed!", checking.getOverDraft());
			System.out.println();
		}
		checking.addToStatement(withdraw,"withdraw", "Checking");
	}
	
	private void displayDepositSaving(Saving saving) {
		
		System.out.println("DEPOSIT INTO SAVINGS ACCT #" + saving.account);
		System.out.printf("Your savings balance is $%.2f", saving.balance);
		System.out.println();
		System.out.print("How much do you want to deposit: $");
		double deposit = input.nextDouble();
		System.out.println();
		saving.doDeposit(deposit);
		saving.addToStatement(deposit, "deposit",  "Savings");
		
	}
	
	private void displayDepositChecking(Checking checking) {
		
		System.out.println("DEPOSIT INTO CHEKCING ACCT #" + checking.account);
		System.out.printf("Your checking balance is $%.2f", checking.balance);
		System.out.println();
		System.out.print("How much do you want to deposit: $");
		double deposit = input.nextDouble();
		System.out.println();
		checking.doDeposit(deposit);
		checking.addToStatement(deposit, "deposit",  "Checking");
		
	}
	
	private void displayLoanPayment(Loan loan) {
		System.out.println("MAKE A PAYMENT TO LOAN ACCT #" + loan.account);
		System.out.printf("Your loan balance is $%.2f", loan.balance);
		System.out.println();
		System.out.print("How much do you want to pay on your loan: $");
		double payment = input.nextDouble();
		System.out.println();
		loan.doWithdraw(payment);
		loan.addToStatement(payment, "payment", "Loan");
	}

}


