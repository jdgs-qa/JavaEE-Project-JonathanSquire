package com.qa.penHeavenAPI.service;

import com.qa.penHeavenAPI.exceptions.AccountNotFoundException;
import com.qa.penHeavenAPI.exceptions.ItemNotFoundExcpetion;
import com.qa.penHeavenAPI.persistence.domain.ItemType;

public interface AccessService {

	String getAllAccounts();

	String createAccount(String account);

	String deleteAccount(String username) throws AccountNotFoundException;

	String updateAccount(String username, String account) throws AccountNotFoundException;

	String getAccountByUsername(String username) throws AccountNotFoundException;

	String getAccountsByFirstName(String firstName) throws AccountNotFoundException;

	String getAccountsByLastName(String lastName) throws AccountNotFoundException;

	String getAccountByEmail(String email) throws AccountNotFoundException;

	String getAllItems();

	String createItem(String item);

	String deleteItem(Long itemId) throws ItemNotFoundExcpetion;

	String updateItem(Long itemId, String item) throws ItemNotFoundExcpetion;

	String getItemByName(String itemName) throws ItemNotFoundExcpetion;

	String getItemsByBrand(String brand) throws ItemNotFoundExcpetion;

	String getItemsByColour(String colour) throws ItemNotFoundExcpetion;

	String getItemsByType(ItemType type) throws ItemNotFoundExcpetion;

	Object getAccountLogin(String password) throws AccountNotFoundException;
}
