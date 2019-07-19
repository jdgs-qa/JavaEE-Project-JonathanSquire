package com.qa.penHeavenAPI.persistence.repo;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.penHeavenAPI.util.JSONUtil;

@Default
@Transactional(value = TxType.SUPPORTS)
public class CatalogueDBRepo implements CatalogueItemRepo {
	
	@Inject
	JSONUtil j = new JSONUtil();
	
	@PersistenceContext(unitName = "primary")
	private EntityManager itemEntityManager;

	public String getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	public String createItem(String item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(value = TxType.REQUIRED)
	public String deleteItem(String itemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(value = TxType.REQUIRED)
	public String updateItem(String itemId, String item) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getItemByName(String itemName) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getItemsByBrand(String brand) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getItemsByColour(String colour) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getItemsByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
