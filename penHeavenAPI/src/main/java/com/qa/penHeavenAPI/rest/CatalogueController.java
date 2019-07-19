package com.qa.penHeavenAPI.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.qa.penHeavenAPI.service.CatalogueService;

@Path("/catalogue")
public class CatalogueController {

	@Inject
	private CatalogueService catalogueService;

	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllItems() {
		return this.catalogueService.getAllItems();
	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public String createItem(String item) {
		return this.catalogueService.createItem(item);
	}

	@DELETE
	@Path("/delete")
	public String deleteItem(String itemId) {
		return this.catalogueService.deleteItem(itemId);
	}

	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateItem(String itemId, String item) {
		return this.catalogueService.updateItem(itemId, item);
	}

	@GET
	@Path("/searchName")
	@Produces(MediaType.APPLICATION_JSON)
	public String getItemByName(String itemName) {
		return this.catalogueService.getItemByName(itemName);
	}

	@GET
	@Path("/searchBrand")
	@Produces(MediaType.APPLICATION_JSON)
	public String getItemByBrand(String itemBrand) {
		return this.catalogueService.getItemsByBrand(itemBrand);
	}

	@GET
	@Path("/searchColour")
	@Produces(MediaType.APPLICATION_JSON)
	public String getItemByColour(String itemColour) {
		return this.catalogueService.getItemsByColour(itemColour);
	}

	@GET
	@Path("/searchType")
	@Produces(MediaType.APPLICATION_JSON)
	public String getItemByType(String itemType) {
		return this.catalogueService.getItemsByType(itemType);
	}
}
