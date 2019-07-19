package com.qa.penHeavenAPI.service;

import javax.inject.Inject;

import com.qa.penHeavenAPI.exceptions.ItemNotFoundExcpetion;
import com.qa.penHeavenAPI.persistence.repo.CatalogueItemRepo;

public class CatalogueServiceImp implements CatalogueService {

	@Inject
	private CatalogueItemRepo catRepo;

	public String getAllItems() {
		return this.catRepo.getAllItems();
	}

	public String createItem(String item) {
		return this.catRepo.createItem(item);
	}

	public String deleteItem(String itemId) throws ItemNotFoundExcpetion {
		return this.catRepo.deleteItem(itemId);
	}
	
	public String updateItem(String itemId, String item) throws ItemNotFoundExcpetion {
		return this.catRepo.updateItem(itemId, item);
	}

	public String getItemByName(String itemName) throws ItemNotFoundExcpetion {
		return this.catRepo.getItemByName(itemName);
	}

	public String getItemsByBrand(String brand) throws ItemNotFoundExcpetion {
		return this.catRepo.getItemsByBrand(brand);
	}

	public String getItemsByColour(String colour) throws ItemNotFoundExcpetion {
		return this.catRepo.getItemsByColour(colour);
	}
	
	public String getItemsByType(String type) throws ItemNotFoundExcpetion {
		return this.catRepo.getItemsByType(type);
	}

}
