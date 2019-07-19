package com.qa.penHeavenAPI.persistence.repo;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.penHeavenAPI.exceptions.ItemNotFoundExcpetion;
import com.qa.penHeavenAPI.persistence.domain.CatalogueItem;
import com.qa.penHeavenAPI.util.JSONUtil;

@Default
@Transactional(value = TxType.SUPPORTS)
public class CatalogueDBRepo implements CatalogueItemRepo {

	@Inject
	JSONUtil j = new JSONUtil();

	@PersistenceContext(unitName = "primary")
	private EntityManager itemEntityManager;

	public String getAllItems() {
		return j.getJSONforObject(this.itemEntityManager.createQuery("Select i FROM Item i", CatalogueItem.class));
	}

	public String createItem(String item) {
		this.itemEntityManager.persist(j.getObjectForJSON(item, CatalogueItem.class));
		return SUCCESS_ADD;
	}

	@Transactional(value = TxType.REQUIRED)
	public String deleteItem(String itemId) {
		CatalogueItem i = this.itemEntityManager.find(CatalogueItem.class, itemId);
		if (i == null) {
			throw new ItemNotFoundExcpetion();
		} else {
			this.itemEntityManager.remove(i);
			return SUCCESS_DEL;
		}

	}

	@Transactional(value = TxType.REQUIRED)
	public String updateItem(String itemId, String item) {
		CatalogueItem iNew = j.getObjectForJSON(item, CatalogueItem.class);
		CatalogueItem iOld = this.itemEntityManager.find(CatalogueItem.class, itemId);
		if (iOld == null) {
			throw new ItemNotFoundExcpetion();
		} else {
			iOld.setItemBrand(iNew.getItemBrand());
			iOld.setItemColour(iNew.getItemColour());
			iOld.setItemName(iNew.getItemName());
			iOld.setItemType(iNew.getItemType());
			this.itemEntityManager.persist(iOld);
			return SUCCESS_UPDATE;
		}
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
