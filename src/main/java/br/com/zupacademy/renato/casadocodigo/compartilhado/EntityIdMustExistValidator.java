package br.com.zupacademy.renato.casadocodigo.compartilhado;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class EntityIdMustExistValidator implements ConstraintValidator<EntityIdMustExist, Object> {
	
	private String domainAttribute;
	private Class<?> klass;

	@PersistenceContext
	private EntityManager em;

	@Override
	public void initialize(EntityIdMustExist params) {
		domainAttribute = params.fieldName();
		klass = params.domainClass();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		
		// Permite o cadastro do Clinte com Estado nulo
		
		if (value == null) {
			return true;
		}
		
		//Consulta no DB utilizando os parametros dinamicos
		
		Query query = em
				.createQuery("SELECT 1 FROM " + klass.getName() + " WHERE " + domainAttribute + " =:VALUE");
		query.setParameter("VALUE", value);
		
		//Atribuiu o resultado da busca a uma lista 

		List<?> list = query.getResultList();
		Assert.state(list.size() <= 1,
				"Foi encontrado mais de um " + klass.getName() + " com o atributo " + domainAttribute + " = " + value);
		return !list.isEmpty();
	}
}
