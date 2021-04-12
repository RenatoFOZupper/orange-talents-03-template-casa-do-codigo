package br.com.zupacademy.renato.casadocodigo.compartilhado;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zupacademy.renato.casadocodigo.estado.EstadoRequest;

public class EstadoPaisValidator implements ConstraintValidator<EstadoPais, EstadoRequest> {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean isValid(EstadoRequest request, ConstraintValidatorContext context) {
		
		Query query = em
				.createQuery("SELECT 1 FROM Estado e WHERE e.nome = :pNome AND e.pais.id = :pIdPais");
				
		query.setParameter("pNome", request.getNome());
		query.setParameter("pIdPais", request.getIdPais());
		

		
		List<?> lista = query.getResultList();
		if (lista.size() < 1) {
			return true;
		}
		return false;
	}
}
