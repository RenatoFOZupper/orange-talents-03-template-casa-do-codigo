package br.com.zupacademy.renato.casadocodigo.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {EmailUnicoValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailUnico {

	String message() default "Email já cadastrado...";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
	String fieldName();
	
	Class<?> domainClass();	
}
