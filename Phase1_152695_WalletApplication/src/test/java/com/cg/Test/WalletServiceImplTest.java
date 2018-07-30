
package com.cg.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.TreeMap;

import org.junit.Test;

import com.cg.WalletApplication.Exception.BankException;
import com.cg.WalletApplication.bean.Customer;
import com.cg.WalletApplication.bean.Wallet;
import com.cg.WalletApplication.service.IWalletService;
import com.cg.WalletApplication.service.WalletServiceImpl;

public class WalletServiceImplTest {
	public static IWalletService iWalletService=new WalletServiceImpl();
    @Test
	public void addCustomerTestTrue() throws BankException
	{
		Customer customer1 = new Customer("9700055566","charan","Charan@123","Charan123@gmail.com",new Wallet(),new TreeMap<LocalDateTime, String>());
		assertEquals("9700055566",iWalletService.addCustomer(customer1));
			
	}
    @Test
  	public void addCustomerTestFalse() throws BankException
  	{

  		Customer customer2 = new Customer("8885556661","sumanth","Sumanth@45","sumanth45@gmail.com",new Wallet(),new TreeMap<LocalDateTime, String>());
  		assertNotEquals("56968621",iWalletService.addCustomer(customer2));
  		
  	}
	

	@Test
	public void initBalanceTest() throws BankException
	{
		Customer customer1 = new Customer("9992255333","samrat","Samrat@789","samrat789@gmail.com",new Wallet(),new TreeMap<LocalDateTime, String>());
		iWalletService.addCustomer(customer1);
		assertEquals(BigDecimal.valueOf(0.0),customer1.getWallet().getBalance());
		
	}
	
	@Test
	public void depositMoneyTest() throws BankException
	{
		Customer customer2 = new Customer("9800980025","Rohith","Rohith@123","Rohith123@gmail.com",new Wallet(),new TreeMap<LocalDateTime, String>());
		iWalletService.addCustomer(customer2);
		iWalletService.deposit(customer2, BigDecimal.valueOf(8500.00));
		Customer result = iWalletService.showBalance("9800980025", "Rohith@123");
		assertEquals(BigDecimal.valueOf(8500.00),result.getWallet().getBalance());
	}
	@Test
	public void withdrawMoneyTestTrue() throws BankException
	{
		Customer customer2 = new Customer("9800980057","Rohith","Rohith@123","Rohith123@gmail.com",new Wallet(),new TreeMap<LocalDateTime, String>());
		iWalletService.addCustomer(customer2);
		iWalletService.deposit(customer2, BigDecimal.valueOf(8500.00));
		assertTrue(iWalletService.withDraw(customer2, BigDecimal.valueOf(3000.00)));
	}

	
	@Test(expected = BankException.class)
	public void withdrawMoneyTestFalse() throws BankException
	{
		Customer customer2 = new Customer("9700504444","Rohith","Rohith@123","Rohith123@gmail.com",new Wallet(),new TreeMap<LocalDateTime, String>());
		iWalletService.addCustomer(customer2);
		iWalletService.deposit(customer2, BigDecimal.valueOf(8500.00));
		assertFalse(iWalletService.withDraw(customer2, BigDecimal.valueOf(9000.00)));
	}

}

