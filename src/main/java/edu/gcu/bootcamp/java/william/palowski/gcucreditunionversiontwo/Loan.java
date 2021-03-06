package edu.gcu.bootcamp.java.william.palowski.gcucreditunionversiontwo;

public class Loan extends Account{
	
	private double interestRate;
	private double lateFee;
	private double newLoanBalance;
	
	public double getNewLoanBalance() {
		return newLoanBalance;
	}

	public void setNewLoanBalance(double newLoanBalance) {
		this.newLoanBalance = newLoanBalance;
	}

	public double getInterestRate() {
		setInterestRate(.09);
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getLateFee() {
		setLateFee(25.00);
		return lateFee;
	}

	public void setLateFee(double lateFee) {
		this.lateFee = lateFee;
	}

	public Loan(double balance, String account) {
		this.balance = balance;
		this.account = account;
		setNewLoanBalance(balance);
	}
	
	

}
