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

import com.qa.penHeavenAPI.exceptions.ItemNotFoundExcpetion;
import com.qa.penHeavenAPI.persistence.domain.ItemType;
import com.qa.penHeavenAPI.service.AccessService;

@Path("/access/catalogue")
public class CatalogueController {

	@Inject
	private AccessService accessService;

	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllItems() {
		try {
			return Response.ok(this.accessService.getAllItems()).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createItem(String item) {
		try {
			return Response.ok(this.accessService.createItem(item)).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}

	@DELETE
	@Path("/delete/{id}")
	public Response deleteItem(@PathParam("id") Long itemId) {
		try {
			return Response.ok(this.accessService.deleteItem(itemId)).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}

	@POST
	@Path("/update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateItem(@PathParam("id") Long itemId, String item) {
		try {
			return Response.ok(this.accessService.updateItem(itemId, item)).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/searchColour")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getItemByColour(String colour) {
		try {
			return Response.ok(this.accessService.getItemsByColour(colour)).build();
		} catch (ItemNotFoundExcpetion infe) {
			return Response.status(Status.NOT_FOUND).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/searchName")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getItemByName(String name) {
		try {
			return Response.ok(this.accessService.getItemByName(name)).build();
		} catch (ItemNotFoundExcpetion infe) {
			return Response.status(Status.NOT_FOUND).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/searchType")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getItemByType(ItemType type) {
		try {
			return Response.ok(this.accessService.getItemsByType(type)).build();
		} catch (ItemNotFoundExcpetion infe) {
			return Response.status(Status.NOT_FOUND).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/searchBrand")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getItemByBrand(String brand) {
		try {
			return Response.ok(this.accessService.getItemsByBrand(brand)).build();
		} catch (ItemNotFoundExcpetion infe) {
			return Response.status(Status.NOT_FOUND).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).build();
		}

	}

}
