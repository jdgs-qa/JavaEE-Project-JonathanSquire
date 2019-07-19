package com.qa.penHeavenAPI.service;

import javax.inject.Inject;

import com.qa.penHeavenAPI.exceptions.AccountNotFoundException;
import com.qa.penHeavenAPI.persistence.repo.AccountRepo;

public class AccountServiceImp implements AccountService{
	
	@Inject
	private AccountRepo accRepo;

	public String getAllAccounts() {
		return this.accRepo.getAllAccounts();
	}

	public String createAccount(String account) {
		return this.accRepo.createAccount(account);
	}

	public String deleteAccount(String username) throws AccountNotFoundException {
		return this.accRepo.deleteAccount(username);
	}

	public String updateAccount(String username, String account) throws AccountNotFoundException {
		return this.accRepo.updateAccount(username, account);
	}

	public String getAccountByUsername(String username) throws AccountNotFoundException {
		return this.accRepo.getAccountByUsername(username);
	}

	public String getAccountsByFirstName(String firstName) throws AccountNotFoundException {
		return this.accRepo.getAccountsByFirstName(firstName);
	}

	public String getAccountsByLastName(String lastName) throws AccountNotFoundException {
		return this.accRepo.getAccountsByLastName(lastName);
	}

	public String getAccountByEmail(String email) throws AccountNotFoundException {
		return this.accRepo.getAccountByEmail(email);
	}

}
