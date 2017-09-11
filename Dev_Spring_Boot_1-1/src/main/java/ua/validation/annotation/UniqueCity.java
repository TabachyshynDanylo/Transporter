package ua.validation.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import ua.validation.validator.CityValidator;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = { CityValidator.class })
public @interface UniqueCity {
	String message() default "Not Unique";
	Class<?>[]groups()default{};
	Class<? extends Payload>[] payload() default{};
}
