package com.example.demo.editor;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.service.CountryService;

@Component
public class CountryEditor extends PropertyEditorSupport {

	@Autowired
	CountryService countryService;

	@Override
	public void setAsText(String pk) throws IllegalArgumentException {
		if (pk != null && pk.length() > 0) {
			setValue(countryService.getById(Integer.valueOf(pk)));
		} else {
			setValue(null);
		}

	}

}
