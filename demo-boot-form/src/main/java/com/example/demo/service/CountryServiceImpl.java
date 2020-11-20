package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Country;

@Service
public class CountryServiceImpl implements CountryService {

	List<Country> CountryList;

	public CountryServiceImpl() {
		this.CountryList = Arrays.asList(new Country(1, "CO", "Colombia"), new Country(2, "CL", "Chile"),
				new Country(3, "AU", "Australia"));
	}

	@Override
	public List<Country> getAll() {
		return CountryList;
	}

	@Override
	public Country getById(Integer id) {
		Country country = CountryList.stream().filter(x -> x.getPk().equals(id)).findAny().orElse(null);
		return country;
	}

}
