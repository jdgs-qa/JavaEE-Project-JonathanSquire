package com.qa.penHeavenAPI.service;

import javax.inject.Inject;

import com.qa.penHeavenAPI.exceptions.AccountNotFoundException;
import com.qa.penHeavenAPI.exceptions.ItemNotFoundExcpetion;
import com.qa.penHeavenAPI.persistence.repo.AccessRepo;

public class AccessServiceImp implements AccessService {

	@Inject
	private AccessRepo accessRepo;

	public String getAllAccounts() {
		return this.accessRepo.getAllAccounts();
	}

	public String createAccount(String account) {
		return this.accessRepo.createAccount(account);
	}

	public String deleteAccount(String username) throws AccountNotFoundException {
		return this.accessRepo.deleteAccount(username);
	}

	public String updateAccount(String username, String account) throws AccountNotFoundException {
		return this.accessRepo.updateAccount(username, account);
	}

	public String getAccountByUsername(String username) throws AccountNotFoundException {
		return this.accessRepo.getAccountByUsername(username);
	}

	public String getAccountsByFirstName(String firstName) throws AccountNotFoundException {
		return this.accessRepo.getAccountsByFirstName(firstName);
	}

	public String getAccountsByLastName(String lastName) throws AccountNotFoundException {
		return this.accessRepo.getAccountsByLastName(lastName);
	}

	public String getAccountByEmail(String email) throws AccountNotFoundException {
		return this.accessRepo.getAccountByEmail(email);
	}

	public String getAllItems() {
		return this.accessRepo.getAllItems();
	}

	public String createItem(String item) {
		return this.accessRepo.createItem(item);
	}

	public String deleteItem(String itemId) throws ItemNotFoundExcpetion {
		return this.accessRepo.deleteItem(itemId);
	}

	public String updateItem(String itemId, String item) throws ItemNotFoundExcpetion {
		return this.accessRepo.updateItem(itemId, item);
	}

	public String getItemByName(String itemName) throws ItemNotFoundExcpetion {
		return this.accessRepo.getItemByName(itemName);
	}

	public String getItemsByBrand(String brand) throws ItemNotFoundExcpetion {
		return this.accessRepo.getItemsByBrand(brand);
	}

	public String getItemsByColour(String colour) throws ItemNotFoundExcpetion {
		return this.accessRepo.getItemsByColour(colour);
	}

	public String getItemsByType(String type) throws ItemNotFoundExcpetion {
		return this.accessRepo.getItemsByType(type);
	}

}
