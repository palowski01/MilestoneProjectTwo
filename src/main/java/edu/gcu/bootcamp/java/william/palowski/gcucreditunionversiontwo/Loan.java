package edu.gcu.bootcamp.java.william.palowski.gcucreditunionversiontwo;

public class Loan extends Account{
	
	private double interestRate;
	private double lateFee;
	
	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getLateFee() {
		return lateFee;
	}

	public void setLateFee(double lateFee) {
		this.lateFee = lateFee;
	}

	public Loan(double balance, String account) {
		this.balance = balance;
		this.account = account;
	}

}
