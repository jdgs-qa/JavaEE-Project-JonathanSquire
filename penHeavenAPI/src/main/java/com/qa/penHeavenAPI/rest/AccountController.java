package com.qa.penHeavenAPI.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.qa.penHeavenAPI.service.AccessService;

@Path("/access/account")
public class AccountController {

	@Inject
	private AccessService accessService;

	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllaccounts() {
		return this.accessService.getAllAccounts();
	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public String createaccount(String account) {
		return this.accessService.createAccount(account);
	}

	@DELETE
	@Path("/delete/{un}")
	public String deleteaccount(@PathParam("un") String userName) {
		return this.accessService.deleteAccount(userName);
	}

	@POST
	@Path("/update/{un}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateAccount(@PathParam("un") String userName, String account) {
		return this.accessService.updateAccount(userName, account);
	}

	@GET
	@Path("/searchUsername/{un}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getaccountByUserName(@PathParam("un") String username) {
		try {
			return Response.ok(this.accessService.getAccountByUsername(username)).build();
		} catch (Exception e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@GET
	@Path("/searchFirstName/{fn}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getaccountByFirstName(@PathParam("fn") String firstName) {
		return this.accessService.getAccountsByFirstName(firstName);
	}

	@GET
	@Path("/searchEmail/{e}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getaccountByEmail(@PathParam("e") String email) {
		return this.accessService.getAccountByEmail(email);
	}

	@GET
	@Path("/searchLastName/{ln}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getaccountByLastName(@PathParam("ln") String lastName) {
		return this.accessService.getAccountsByLastName(lastName);
	}

}
