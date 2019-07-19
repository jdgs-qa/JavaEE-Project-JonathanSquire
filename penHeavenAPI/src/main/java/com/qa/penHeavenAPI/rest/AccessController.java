package com.qa.penHeavenAPI.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.qa.penHeavenAPI.service.AccessService;

@Path("/account")
public class AccessController {

	@Inject
	private AccessService accessService;

	@GET
	@Path("/account/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllaccounts() {
		return this.accessService.getAllAccounts();
	}

	@POST
	@Path("/account/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public String createaccount(String account) {
		return this.accessService.createAccount(account);
	}

	@DELETE
	@Path("/account/delete")
	public String deleteaccount(String userName) {
		return this.accessService.createAccount(userName);
	}

	@POST
	@Path("/account/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateaccount(String userName, String account) {
		return this.accessService.updateAccount(userName, account);
	}

	@GET
	@Path("/account/searchUsername")
	@Produces(MediaType.APPLICATION_JSON)
	public String getaccountByName(String userName) {
		return this.accessService.getAccountByEmail(userName);
	}

	@GET
	@Path("/account/searchFirstName")
	@Produces(MediaType.APPLICATION_JSON)
	public String getaccountByFirstName(String firstName) {
		return this.accessService.getAccountByEmail(firstName);
	}

	@GET
	@Path("/account/searchEmail")
	@Produces(MediaType.APPLICATION_JSON)
	public String getaccountByEmail(String email) {
		return this.accessService.getAccountByEmail(email);
	}

	@GET
	@Path("/account/searchLastName")
	@Produces(MediaType.APPLICATION_JSON)
	public String getaccountByLastName(String lastName) {
		return this.accessService.getAccountByEmail(lastName);
	}

	@GET
	@Path("/catalogue/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllItems() {
		return this.accessService.getAllItems();
	}

	@POST
	@Path("/catalogue/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public String createItem(String item) {
		return this.accessService.createItem(item);
	}

	@DELETE
	@Path("/catalogue/delete")
	public String deleteItem(String itemId) {
		return this.accessService.deleteItem(itemId);
	}

	@POST
	@Path("/catalogue/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateItem(String itemId, String item) {
		return this.accessService.updateItem(itemId, item);
	}

	@GET
	@Path("/catalogue/searchName")
	@Produces(MediaType.APPLICATION_JSON)
	public String getItemByName(String itemName) {
		return this.accessService.getItemByName(itemName);
	}

	@GET
	@Path("/catalogue/searchBrand")
	@Produces(MediaType.APPLICATION_JSON)
	public String getItemByBrand(String itemBrand) {
		return this.accessService.getItemsByBrand(itemBrand);
	}

	@GET
	@Path("/catalogue/searchColour")
	@Produces(MediaType.APPLICATION_JSON)
	public String getItemByColour(String itemColour) {
		return this.accessService.getItemsByColour(itemColour);
	}

	@GET
	@Path("/catalogue/searchType")
	@Produces(MediaType.APPLICATION_JSON)
	public String getItemByType(String itemType) {
		return this.accessService.getItemsByType(itemType);
	}
}
