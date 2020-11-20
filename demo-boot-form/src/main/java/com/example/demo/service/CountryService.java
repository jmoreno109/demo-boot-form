package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Country;

public interface CountryService {
	
	public List<Country> getAll();
	public Country getById(Integer id);

}
