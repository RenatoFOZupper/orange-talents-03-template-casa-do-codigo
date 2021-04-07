package br.com.zupacademy.renato.casadocodigo.validators;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

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
		Query query = em
				.createQuery("SELECT 1 FROM " + klass.getName() + " WHERE " + domainAttribute + " =:VALUE");
		query.setParameter("VALUE", value);

		List<?> list = query.getResultList();
		return !list.isEmpty();
	}
}
