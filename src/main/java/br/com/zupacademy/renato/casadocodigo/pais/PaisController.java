package br.com.zupacademy.renato.casadocodigo.pais;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaisController {
	
	private PaisRepository repository;
	
	public PaisController(PaisRepository repository) {
		this.repository = repository;
	}

	@PostMapping(value = "/paises")
	@Transactional
	public ResponseEntity<PaisResponse> cadastraPais(@RequestBody @Valid PaisRequest request) {
		Pais pais = request.toModel();
		pais = repository.save(pais);
		PaisResponse response = new PaisResponse(pais);
		return ResponseEntity.ok(response);
	}
	
}
