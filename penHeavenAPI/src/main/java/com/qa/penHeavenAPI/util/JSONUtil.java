package com.qa.penHeavenAPI.util;

import com.google.gson.Gson;

public class JSONUtil {

	private Gson gson;
	
	public JSONUtil() {
		this.gson = new Gson();
	}
	
	public String getJSONforObject(Object o) {
		return this.gson.toJson(o);
		
	}
	
	public <T> T getObjectForJSON(String json, Class<T> clazz) {
		return this.gson.fromJson(json, clazz);
	}
}
