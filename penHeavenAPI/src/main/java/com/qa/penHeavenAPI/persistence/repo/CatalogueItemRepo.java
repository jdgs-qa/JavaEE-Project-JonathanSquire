package com.qa.penHeavenAPI.persistence.repo;

public interface CatalogueItemRepo {

	String getAllItems();
	
	String createItem(String item);
	
	String deleteItem(String itemId);
	
	String updateItem(String itemId, String item);
	
	String getItemByName(String itemName);
	
	String getItemsByBrand(String brand);
	
	String getItemsByColour(String colour);
	
	String getItemsByType(String type);
}
