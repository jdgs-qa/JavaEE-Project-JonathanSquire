package com.qa.penHeavenAPI.persistence.repo;

public interface AccountRepo {
	
	public static final String SUCCESS_ADD = "Successfully created account";
	public static final String FAIL_ADD = "Failed to create account";
	public static final String SUCCESS_DEL = "Successfully deleted account";
	public static final String FAIL_DEL = "Failed to delete account";
	public static final String SUCCESS_UPDATE = "Successfully updated account details";
	public static final String FAIL_UPDATE = "Failed to update account details";

	String getAllAccounts();
	
	String createAccount(String account);
	
	String deleteAccount(String username);
	
	String updateAccount(String username, String account);
	
	String getAccountByUsername(String username);
	
	String getAccountsByFirstName(String firstName);
	
	String getAccountsByLastName(String lastName);
	
	String getAccountByEmail(String email);
	
}
