package com.example.demo.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.demo.dto.User;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmpty(errors, "username", "NotEmpty.user.username");

		/*User user = (User) target;
		if (user.getClient().matches("[0-9]{3}[.][\\d]{3}[-][A-Z]{1}") == false) {
			errors.rejectValue("client", "pattern.user.client");
		}*/

	}

}
