package br.com.zupacademy.renato.casadocodigo.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {EntityIdMustExistValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EntityIdMustExist {

	String message() default "Necessário um id válido...";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	String fieldName();
	Class<?> domainClass();	
}
