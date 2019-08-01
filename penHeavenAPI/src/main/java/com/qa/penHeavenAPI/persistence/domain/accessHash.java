package com.qa.penHeavenAPI.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class accessHash {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accessId;

	private String accessHash;

	public Long getAccessId() {
		return accessId;
	}

	public void setAccessId(Long accessId) {
		this.accessId = accessId;
	}

	public String getAccessHash() {
		return accessHash;
	}

	public void setAccessHash(String accessHash) {
		this.accessHash = accessHash;
	}

	public accessHash(Long accessId, String accessHash) {
		super();
		this.accessId = accessId;
		this.accessHash = accessHash;
	}

	public accessHash() {
		super();
	}

}
