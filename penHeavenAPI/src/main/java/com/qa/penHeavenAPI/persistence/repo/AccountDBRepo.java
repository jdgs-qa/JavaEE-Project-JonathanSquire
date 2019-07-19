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
public class AccountDBRepo implements AccountRepo {
	
	@Inject
	JSONUtil j = new JSONUtil();
	
	@PersistenceContext(unitName = "primary")
	private EntityManager accountEntityManager;

	public String getAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	public String createAccount(String account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(value = TxType.REQUIRED)
	public String deleteAccount(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(value = TxType.REQUIRED)
	public String updateAccount(String username, String account) {
		// TODO Auto-generated method stub
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
