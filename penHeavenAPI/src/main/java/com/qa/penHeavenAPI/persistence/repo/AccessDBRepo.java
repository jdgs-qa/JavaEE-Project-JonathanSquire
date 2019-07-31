package com.qa.penHeavenAPI.persistence.repo;

import java.util.Optional;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.penHeavenAPI.exceptions.AccountNotFoundException;
import com.qa.penHeavenAPI.exceptions.ItemNotFoundExcpetion;
import com.qa.penHeavenAPI.persistence.domain.Account;
import com.qa.penHeavenAPI.persistence.domain.CatalogueItem;
import com.qa.penHeavenAPI.persistence.domain.ItemType;
import com.qa.penHeavenAPI.util.JSONUtil;

@Default
@Transactional(value = TxType.SUPPORTS)
public class AccessDBRepo implements AccessRepo {

	@Inject
	JSONUtil j = new JSONUtil();

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Override
	public String getAllAccounts() {
		TypedQuery<Account> query = this.em.createQuery("SELECT a FROM Account a", Account.class);
		return j.getJSONforObject(query.getResultList());
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public String createAccount(String account) {
		this.em.persist(j.getObjectForJSON(account, Account.class));
		return SUCCESS_ADD_ACCOUNT;
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public String deleteAccount(String username) {
		Account a = this.em.createQuery("SELECT DISTINCT a FROM Account a WHERE a.userName = :un", Account.class)
				.setParameter("un", username).getSingleResult();
		if (a == null) {
			return FAIL_DEL_ACCOUNT;
		} else {
			this.em.remove(a);
			return SUCCESS_DEL_ACCOUNT;
		}

	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public String updateAccount(String username, String account) {
		Account aNew = j.getObjectForJSON(account, Account.class);
		Account aOld = this.em.createQuery("SELECT DISTINCT a FROM Account a WHERE a.userName = :un", Account.class)
				.setParameter("un", username).getSingleResult();
		if (aOld == null) {
			throw new AccountNotFoundException();
		} else {
			aOld.setEmail(aNew.getEmail());
			aOld.setFirstName(aNew.getFirstName());
			aOld.setLastName(aNew.getLastName());
			aOld.setUserName(aNew.getUserName());
			aOld.setPassword(aNew.getPassword());
			this.em.persist(aOld);
			return SUCCESS_UPDATE_ACCOUNT;
		}
	}

	@Override
	public String getAccountByUsername(String username) throws AccountNotFoundException {
		TypedQuery<Account> query = this.em
				.createQuery("SELECT DISTINCT a FROM Account a WHERE a.userName = :un", Account.class)
				.setParameter("un", username);
		Optional<Account> account = null;
		try {
			account = Optional.of(query.getSingleResult());
		} catch (Exception e) {
			throw new AccountNotFoundException();
		}
		return j.getJSONforObject(account.orElseThrow(() -> new AccountNotFoundException()));
	}

	@Override
	public String getAccountsByFirstName(String firstName) {
		TypedQuery<Account> query = this.em
				.createQuery("SELECT a FROM Account a WHERE a.firstName LIKE :fn", Account.class)
				.setParameter("fn", firstName).setMaxResults(10);
		return j.getJSONforObject(query.getResultList());
	}

	@Override
	public String getAccountByEmail(String email) {
		TypedQuery<Account> query = this.em.createQuery("SELECT a FROM Account a WHERE a.email LIKE :e", Account.class)
				.setParameter("e", email).setMaxResults(10);
		return j.getJSONforObject(query.getResultList());
	}

	@Override
	public String getAccountsByLastName(String lastName) {
		TypedQuery<Account> query = this.em
				.createQuery("SELECT a FROM Account a WHERE a.lastName LIKE :ln", Account.class)
				.setParameter("ln", lastName).setMaxResults(10);
		return j.getJSONforObject(query.getResultList());
	}

	@Override
	public String getAllItems() {
		TypedQuery<CatalogueItem> query = this.em.createQuery("SELECT a FROM CatalogueItem a", CatalogueItem.class);
		return j.getJSONforObject(query.getResultList());
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public String createItem(String item) {
		this.em.persist(j.getObjectForJSON(item, CatalogueItem.class));
		return SUCCESS_ADD_ITEM;
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public String deleteItem(Long itemId) {
		CatalogueItem i = this.em.find(CatalogueItem.class, itemId);
		if (i == null) {
			throw new ItemNotFoundExcpetion();
		} else {
			this.em.remove(i);
			return SUCCESS_DEL_ITEM;
		}

	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public String updateItem(Long itemId, String item) {
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

	@Override
	public String getItemByName(String itemName) {
		TypedQuery<CatalogueItem> query = this.em
				.createQuery("SELECT c FROM CatalogueItem c WHERE c.itemName LIKE :itemName %", CatalogueItem.class)
				.setParameter("itemName", itemName).setMaxResults(10);
		return j.getJSONforObject(query.getResultList());
	}

	@Override
	public String getItemsByBrand(String brand) {
		TypedQuery<CatalogueItem> query = this.em
				.createQuery("SELECT c FROM CatalogueItem c WHERE c.itemBrand LIKE :itemBrand %", CatalogueItem.class)
				.setParameter("itemBrand", brand).setMaxResults(10);
		return j.getJSONforObject(query.getResultList());
	}

	@Override
	public String getItemsByColour(String colour) {
		TypedQuery<CatalogueItem> query = this.em
				.createQuery("SELECT c FROM CatalogueItem c WHERE c.itemColour LIKE :colour %", CatalogueItem.class)
				.setParameter("colour", colour).setMaxResults(10);
		return j.getJSONforObject(query.getResultList());
	}

	@Override
	public String getItemsByType(ItemType type) {
		TypedQuery<CatalogueItem> query = this.em
				.createQuery("SELECT c FROM CatalogueItem c WHERE c.itemType LIKE :type %", CatalogueItem.class)
				.setParameter("type", type).setMaxResults(10);
		return j.getJSONforObject(query.getResultList());
	}

	@Override
	public Object getAccountLogin(String username) {
		TypedQuery<Account> query = this.em
				.createQuery("SELECT DISTINCT a FROM Account a WHERE a.userName = :un", Account.class)
				.setParameter("un", username);
		Optional<Account> account = null;
		try {
			account = Optional.of(query.getSingleResult());
		} catch (Exception e) {
			throw new AccountNotFoundException();
		}
		return j.getJSONforObject(account.orElseThrow(() -> new AccountNotFoundException()));
	}

}
