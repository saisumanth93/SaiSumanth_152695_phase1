package com.cg.WalletApplication.Exception;

public interface IBankException {

	String nameException ="Enter Valid Name";
	String mobileNumberException = "Enter Valid Mobile Number ";
	String passwordException ="Enter Valid Password";
	String emailIdException = " enter valid email id";
	String invalidDetails = "The details given by you are incorrect ";
	String insufficientFunds = "Insufficient account balance";
	String ACCOUNTEXISTS = "Account already exists with the given mobile number";
}
