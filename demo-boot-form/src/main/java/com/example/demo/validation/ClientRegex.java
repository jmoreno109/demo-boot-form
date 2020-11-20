package com.example.demo.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = ClientRegexValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface ClientRegex {

	String message() default "client no es valido !!!";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
