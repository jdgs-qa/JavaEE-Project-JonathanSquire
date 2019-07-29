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

import com.qa.penHeavenAPI.persistence.domain.ItemType;
import com.qa.penHeavenAPI.service.AccessService;

@Path("/access/catalogue")
public class CatalogueController {

	@Inject
	private AccessService accessService;

	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllItems() {
		return this.accessService.getAllItems();
	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public String createItem(String item) {
		return this.accessService.createItem(item);
	}

	@DELETE
	@Path("/delete/{id}")
	public String deleteItem(@PathParam("id") Long itemId) {
		return this.accessService.deleteItem(itemId);
	}

	@POST
	@Path("/update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateItem(@PathParam("id") Long itemId, String item) {
		return this.accessService.updateItem(itemId, item);
	}

	@GET
	@Path("/searchColour/{c}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getItemByColour(@PathParam("c") String colour) {
		return this.accessService.getItemsByColour(colour);
	}

	@GET
	@Path("/searchName/{n}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getItemByName(@PathParam("n") String name) {
		return this.accessService.getItemByName(name);
	}

	@GET
	@Path("/searchType/{t}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getItemByColour(@PathParam("t") ItemType type) {
		return this.accessService.getItemsByType(type);
	}

	@GET
	@Path("/searchBrand/{b}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getItemByBrand(@PathParam("b") String brand) {
		return this.accessService.getItemsByBrand(brand);
	}

}
