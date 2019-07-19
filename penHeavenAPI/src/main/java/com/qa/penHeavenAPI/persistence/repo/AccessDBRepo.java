package com.qa.penHeavenAPI.persistence.repo;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.penHeavenAPI.exceptions.AccountNotFoundException;
import com.qa.penHeavenAPI.exceptions.ItemNotFoundExcpetion;
import com.qa.penHeavenAPI.persistence.domain.Account;
import com.qa.penHeavenAPI.persistence.domain.CatalogueItem;
import com.qa.penHeavenAPI.util.JSONUtil;

@Default
@Transactional(value = TxType.SUPPORTS)
public class AccessDBRepo implements AccessRepo {

	@Inject
	JSONUtil j = new JSONUtil();

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	public String getAllAccounts() {
		return j.getJSONforObject(this.em.createQuery("SELECT a FROM Account a", Account.class));
	}

	public String createAccount(String account) {
		this.em.persist(j.getObjectForJSON(account, Account.class));
		return SUCCESS_ADD_ACCOUNT;
	}

	@Transactional(value = TxType.REQUIRED)
	public String deleteAccount(String username) {
		Account a = this.em.find(Account.class, username);
		if (a == null) {
			throw new AccountNotFoundException();
		} else {
			this.em.remove(a);
		}
		return SUCCESS_DEL_ACCOUNT;
	}

	@Transactional(value = TxType.REQUIRED)
	public String updateAccount(String username, String account) {
		Account aNew = j.getObjectForJSON(account, Account.class);
		Account aOld = this.em.find(Account.class, username);
		if (aOld == null) {
			throw new AccountNotFoundException();
		} else {
			aOld.setEmail(aNew.getEmail());
			aOld.setFirstName(aNew.getFirstName());
			aOld.setLastName(aNew.getLastName());
			aOld.setUserName(aNew.getUserName());
			this.em.persist(aOld);
		}
		return null;
	}

	public String getAccountByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAccountsByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAccountByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAccountsByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAllItems() {
		return j.getJSONforObject(this.em.createQuery("Select i FROM Item i", CatalogueItem.class));
	}

	public String createItem(String item) {
		this.em.persist(j.getObjectForJSON(item, CatalogueItem.class));
		return SUCCESS_ADD_ITEM;
	}

	@Transactional(value = TxType.REQUIRED)
	public String deleteItem(String itemId) {
		CatalogueItem i = this.em.find(CatalogueItem.class, itemId);
		if (i == null) {
			throw new ItemNotFoundExcpetion();
		} else {
			this.em.remove(i);
			return SUCCESS_DEL_ITEM;
		}

	}

	@Transactional(value = TxType.REQUIRED)
	public String updateItem(String itemId, String item) {
		CatalogueItem iNew = j.getObjectForJSON(item, CatalogueItem.class);
		CatalogueItem iOld = this.em.find(CatalogueItem.class, itemId);
		if (iOld == null) {
			throw new ItemNotFoundExcpetion();
		} else {
			iOld.setItemBrand(iNew.getItemBrand());
			iOld.setItemColour(iNew.getItemColour());
			iOld.setItemName(iNew.getItemName());
			iOld.setItemType(iNew.getItemType());
			this.em.persist(iOld);
			return SUCCESS_UPDATE_ITEM;
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
