package com.qa.penHeavenAPI.persistence.repo;

public interface CatalogueItemRepo {
	
	public static final String SUCCESS_ADD = "Successfully added item to catalogue";
	public static final String FAIL_ADD = "Failed to add item to catalogue";
	public static final String SUCCESS_DEL = "Successfully deleted item from catalogue";
	public static final String FAIL_DEL = "Failed to delete item from catalogue";
	public static final String SUCCESS_UPDATE = "Successfully updated item details";
	public static final String FAIL_UPDATE = "Failed to update item details";
	

	String getAllItems();
	
	String createItem(String item);
	
	String deleteItem(String itemId);
	
	String updateItem(String itemId, String item);
	
	String getItemByName(String itemName);
	
	String getItemsByBrand(String brand);
	
	String getItemsByColour(String colour);
	
	String getItemsByType(String type);
}
