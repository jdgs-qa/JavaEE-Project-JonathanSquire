package com.qa.penHeavenAPI.persistence.repo;

public interface AccountRepo {

	String getAllAccounts();
	
	String createAccount(String account);
	
	String deleteAccount(String username);
	
	String updateAccount(String username, String account);
	
	String getAccountByUsername(String username);
	
	String getAccountsByFirstName(String firstName);
	
	String getAccountsByLastName(String lastName);
	
	String getAccountByEmail(String email);
	
}
