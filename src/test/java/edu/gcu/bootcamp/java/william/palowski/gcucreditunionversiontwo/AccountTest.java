package edu.gcu.bootcamp.java.william.palowski.gcucreditunionversiontwo;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

//Test both deposit and withdrawl from an account
//Makes sure that it passes back the correct account balance

public class AccountTest {
	
	Account acct = new Account();

	@Test
	public void testDoDeposit() {
		
		double amount = 1000.0;
		acct.setBalance(amount);
		double expected = 1000.0;
		double actual = acct.getBalance();
		assertEquals(actual,expected);
	}
	
	@Test
	public void testDoWithdraw() {
		acct.setBalance(1000.00);
		double amount = 500.00;
		acct.doWithdraw(amount);
		double expected = 500.00;
		double actual = acct.getBalance();
		assertEquals(actual,expected);
		
	}

}
