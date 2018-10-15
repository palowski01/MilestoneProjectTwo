package edu.gcu.bootcamp.java.william.palowski.gcucreditunionversiontwo;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class Account implements MonthlyStatement{

	protected static List<String> statement = new ArrayList<String>();;
	protected double balance;
	protected String account;
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	public void doWithdraw(double amount) {
		double newBalance = this.balance - amount;
		this.setBalance(newBalance);
		
	}
	
	public void doDeposit(double amount) {
		double newBalance = this.balance + amount;
		this.setBalance(newBalance);
		
	}
	
	public void addToStatement(double amount, String transActionType, String accountType) {
		LocalDate date = LocalDate.now();
		List<String> statement = getStatement();
		DecimalFormat df = new DecimalFormat(".##");
		//The line below is for testing end of month purposes only
		//comment out this line if you want the program to run normal
//		date = date.with(TemporalAdjusters.lastDayOfMonth());
		
//		if(date == date.with(TemporalAdjusters.lastDayOfMonth())) {
//			statement.clear();
//		}
		statement.add(LocalDate.now() + "\t" + this.account + " \t" + transActionType + " \t$" + df.format(amount) + "0 \t$" + df.format(this.balance) + "0 \t" + accountType);
		setStatement(statement);
	}

	public static void displayStatement() {
		System.out.println("=========================================");
		System.out.println("               STATEMENT FOR                 ");
		System.out.println("            \t" + LocalDate.now().getMonth() + "              ");
		System.out.println("=========================================");
		System.out.println("=========================================");
		for (String str : statement) {
			System.out.println(str);
		}
	}
	public static List<String> getStatement() {
		return statement;
	}
	public static void setStatement(List<String> statement) {
		Account.statement = statement;
	}
	
	public static void clearStatement() {
		statement.clear();
	}
}

