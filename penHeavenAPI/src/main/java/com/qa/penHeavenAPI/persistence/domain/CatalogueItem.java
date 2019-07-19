package com.qa.penHeavenAPI.persistence.domain;

import javax.persistence.Entity;

@Entity
public class CatalogueItem {

	private Long itemId;
	private String itemName;
	private String itemBrand;
	private String itemType;
	private String itemColour;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemBrand() {
		return itemBrand;
	}

	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemColour() {
		return itemColour;
	}

	public void setItemColour(String itemColour) {
		this.itemColour = itemColour;
	}

	public CatalogueItem(Long itemId, String itemName, String itemBrand, String itemType, String itemColour) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemBrand = itemBrand;
		this.itemType = itemType;
		this.itemColour = itemColour;
	}

	public CatalogueItem() {
		super();
	}

}
