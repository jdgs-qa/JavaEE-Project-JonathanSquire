package com.qa.penHeavenAPI.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.qa.penHeavenAPI.service.AccountService;

@Path("/account")
public class AccountController {

	@Inject
	private AccountService accountService;

	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllaccounts() {
		return this.accountService.getAllAccounts();
	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public String createaccount(String account) {
		return this.accountService.createAccount(account);
	}

	@DELETE
	@Path("/delete")
	public String deleteaccount(String userName) {
		return this.accountService.createAccount(userName);
	}

	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateaccount(String userName, String account) {
		return this.accountService.updateAccount(userName, account);
	}

	@GET
	@Path("/searchUsername")
	@Produces(MediaType.APPLICATION_JSON)
	public String getaccountByName(String userName) {
		return this.accountService.getAccountByEmail(userName);
	}

	@GET
	@Path("/searchFirstName")
	@Produces(MediaType.APPLICATION_JSON)
	public String getaccountByFirstName(String firstName) {
		return this.accountService.getAccountByEmail(firstName);
	}

	@GET
	@Path("/searchEmail")
	@Produces(MediaType.APPLICATION_JSON)
	public String getaccountByEmail(String email) {
		return this.accountService.getAccountByEmail(email);
	}

	@GET
	@Path("/searchLastName")
	@Produces(MediaType.APPLICATION_JSON)
	public String getaccountByLastName(String lastName) {
		return this.accountService.getAccountByEmail(lastName);
	}
}
