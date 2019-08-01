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

import com.qa.penHeavenAPI.exceptions.PasswordMissmatchException;
import com.qa.penHeavenAPI.service.AccessService;

@Path("/access/account")
public class AccountController {

	@Inject
	private AccessService accessService;

	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllaccounts() {
		try {
			return Response.ok(this.accessService.getAllAccounts()).build();
		} catch (PasswordMissmatchException pme) {
			return Response.status(Status.FORBIDDEN).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).build();
		}

	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createaccount(String account) {
		try {
			return Response.ok(this.accessService.createAccount(account)).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}

	@DELETE
	@Path("/delete/{un}")
	public Response deleteaccount(@PathParam("un") String userName) {
		try {
			return Response.ok(this.accessService.deleteAccount(userName)).build();
		} catch (Exception e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@POST
	@Path("/update/{un}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateAccount(@PathParam("un") String userName, String account) {
		try {
			return Response.ok(this.accessService.updateAccount(userName, account)).build();
		} catch (Exception e) {
			return Response.status(Status.NOT_FOUND).build();
		}
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
	@Path("/login/{un}")
	public Response getaccountLogin(@PathParam("un") String username, String password) {
		try {
			return Response.ok(this.accessService.getAccountLogin(username, password)).build();
		} catch (PasswordMissmatchException pme) {
			return Response.status(Status.FORBIDDEN).build();
		} catch (Exception e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@GET
	@Path("/searchFirstName/{fn}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getaccountByFirstName(@PathParam("fn") String firstName) {
		try {
			return Response.ok(this.accessService.getAccountsByFirstName(firstName)).build();
		} catch (Exception e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@GET
	@Path("/searchEmail/{e}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getaccountByEmail(@PathParam("e") String email) {
		try {
			return Response.ok(this.accessService.getAccountByEmail(email)).build();
		} catch (Exception e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@GET
	@Path("/searchLastName/{ln}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getaccountByLastName(@PathParam("ln") String lastName) {
		try {
			return Response.ok(this.accessService.getAccountsByLastName(lastName)).build();
		} catch (Exception e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

}
