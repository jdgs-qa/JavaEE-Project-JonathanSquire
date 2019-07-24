package com.qa.penHeavenAPI.exceptions;

public class ItemNotFoundExcpetion extends RuntimeException{

	private static final long serialVersionUID = 2657498265981536006L;
	
	private String exceptionString = "ITEM_NOT_FOUND";

	public ItemNotFoundExcpetion() {
		super();
	}

	public String getExceptionString() {
		return exceptionString;
	}

	public void setExceptionString(String exceptionString) {
		this.exceptionString = exceptionString;
	}
	
	

}
