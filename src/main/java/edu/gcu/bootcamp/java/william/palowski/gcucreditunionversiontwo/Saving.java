package edu.gcu.bootcamp.java.william.palowski.gcucreditunionversiontwo;

public class Saving extends Account{
	
	private double serviceFee;
	private double annualInterestRate;
	private double minBalance;
	
	public double getServiceFee() {
		setServiceFee(25.00);
		return serviceFee;
	}
	public void setServiceFee(double serviceFee) {
		this.serviceFee = serviceFee;
	}
	public double getAnnualInterestRate() {
		setAnnualInterestRate(.03);
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	public double getMinBalance() {
		setMinBalance(200.00);
		return minBalance;
	}
	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}
	
	public Saving(double balance, String account) {
		this.balance = balance;
		this.account = account;
	}
	
	
}



