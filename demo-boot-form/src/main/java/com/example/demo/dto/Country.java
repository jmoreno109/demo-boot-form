package com.example.demo.dto;

import javax.validation.constraints.NotEmpty;

public class Country {
	
	private Integer pk;
	
	@NotEmpty
	private String code;
	private String name;

	public Country() {
	}

	public Country(Integer pk, String code, String name) {
		this.pk = pk;
		this.code = code;
		this.name = name;
	}

	public Integer getPk() {
		return pk;
	}

	public void setPk(Integer pk) {
		this.pk = pk;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
