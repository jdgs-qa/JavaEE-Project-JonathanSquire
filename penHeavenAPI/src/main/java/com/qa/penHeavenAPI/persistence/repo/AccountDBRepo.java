package com.qa.penHeavenAPI.persistence.repo;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.penHeavenAPI.exceptions.AccountNotFoundException;
import com.qa.penHeavenAPI.persistence.domain.Account;
import com.qa.penHeavenAPI.util.JSONUtil;

@Default
@Transactional(value = TxType.SUPPORTS)
public class AccountDBRepo implements AccountRepo {

	@Inject
	JSONUtil j = new JSONUtil();

	@PersistenceContext(unitName = "primary")
	private EntityManager accountEntityManager;

	public String getAllAccounts() {
		return j.getJSONforObject(this.accountEntityManager.createQuery("SELECT a FROM Account a", Account.class));
	}

	public String createAccount(String account) {
		this.accountEntityManager.persist(j.getObjectForJSON(account, Account.class));
		return SUCCESS_ADD;
	}

	@Transactional(value = TxType.REQUIRED)
	public String deleteAccount(String username) {
		Account a = this.accountEntityManager.find(Account.class, username);
		if (a == null) {
			throw new AccountNotFoundException();
		} else {
			this.accountEntityManager.remove(a);
		}
		return SUCCESS_DEL;
	}

	@Transactional(value = TxType.REQUIRED)
	public String updateAccount(String username, String account) {
		Account aNew = j.getObjectForJSON(account, Account.class);
		Account aOld = this.accountEntityManager.find(Account.class, username);
		if (aOld == null) {
			throw new AccountNotFoundException();
		} else {
			aOld.setEmail(aNew.getEmail());
			aOld.setFirstName(aNew.getFirstName());
			aOld.setLastName(aNew.getLastName());
			aOld.setUserName(aNew.getUserName());
			this.accountEntityManager.persist(aOld);
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

}
