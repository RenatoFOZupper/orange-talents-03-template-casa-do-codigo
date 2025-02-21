package br.com.zupacademy.renato.casadocodigo.compartilhado;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {EstadoPaisTesteValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface EstadoPaisTeste {

	String message() default "Campo de valor único já cadastrado...";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	String typeError();
}


