package com.qa.penHeavenAPI.service;

import com.qa.penHeavenAPI.exceptions.ItemNotFoundExcpetion;

public interface CatalogueService {

	String getAllItems();
	
	String createItem(String item);
	
	String deleteItem(String itemId) throws ItemNotFoundExcpetion;
	
	String updateItem(String itemId, String item)  throws ItemNotFoundExcpetion;
	
	String getItemByName(String itemName)  throws ItemNotFoundExcpetion;
	
	String getItemsByBrand(String brand)  throws ItemNotFoundExcpetion;
	
	String getItemsByColour(String colour)  throws ItemNotFoundExcpetion;
	
	String getItemsByType(String type)  throws ItemNotFoundExcpetion;
}
