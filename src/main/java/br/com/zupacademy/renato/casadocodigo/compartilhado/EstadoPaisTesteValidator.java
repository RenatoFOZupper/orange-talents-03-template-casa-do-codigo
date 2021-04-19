package br.com.zupacademy.renato.casadocodigo.compartilhado;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zupacademy.renato.casadocodigo.cliente.ClienteRequest;

public class EstadoPaisTesteValidator implements ConstraintValidator<EstadoPaisTeste, ClienteRequest> {

	
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean isValid(ClienteRequest request, ConstraintValidatorContext context) {

		// Atribuo os valores do ClienteRequest para variaveis locais

		Long idPais = request.getIdPais();
		Long idEstado = request.getIdEstado();

		Query query;
		List<?> resultList;
		String sql;

		/*
		 * Caso o estado informado seja nulo, verifico se o pais informado possui
		 * estados. Se o pais possuir estados retorno um erro
		 * "O pais selecionado possui estados validos", caso o pais nao possua estados
		 * valido a informação com estado nulo
		 */

		if (idEstado == null) {
			sql = "SELECT 1 FROM Estado e WHERE e.pais.id = :pIdPais";

			query = em.createQuery(sql);
			query.setParameter("pIdPais", idPais);

			resultList = query.getResultList();

			return resultList.isEmpty() ? true : false;

		} else {

			/*
			 * Verifico se o estado informado corresponde ao pais informado Caso bata a
			 * informacao valido o request, caso contrario retorno um erro
			 * "idEstado nao corresponde ao idPais"
			 */

			sql = "SELECT 1 FROM Estado e JOIN e.pais p WHERE p.id = :pIdPais AND e.id = :pIdEstado";

			query = em.createQuery(sql);
			query.setParameter("pIdPais", idPais);
			query.setParameter("pIdEstado", idEstado);

			resultList = query.getResultList();

			return resultList.isEmpty() ? false : true;
		}
	}
}
