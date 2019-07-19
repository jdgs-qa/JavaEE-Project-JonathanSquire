package com.qa.penHeavenAPI.service;

import com.qa.penHeavenAPI.exceptions.AccountNotFoundException;

public interface AccountService {

	String getAllAccounts();
	
	String createAccount(String account);
	
	String deleteAccount(String username) throws AccountNotFoundException;
	
	String updateAccount(String username, String account) throws AccountNotFoundException;
	
	String getAccountByUsername(String username) throws AccountNotFoundException;
	
	String getAccountsByFirstName(String firstName) throws AccountNotFoundException;
	
	String getAccountsByLastName(String lastName) throws AccountNotFoundException;
	
	String getAccountByEmail(String email) throws AccountNotFoundException;
}
