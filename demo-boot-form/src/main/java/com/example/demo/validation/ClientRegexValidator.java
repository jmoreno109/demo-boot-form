package com.example.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ClientRegexValidator implements ConstraintValidator<ClientRegex, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value.matches("[0-9]{3}[.][\\d]{3}[-][A-Z]{1}")) {
			return true;
		}
		return false;
	}

}
