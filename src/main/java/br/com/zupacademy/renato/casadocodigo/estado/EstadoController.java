package br.com.zupacademy.renato.casadocodigo.estado;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.renato.casadocodigo.pais.PaisRepository;

@RestController
public class EstadoController {
	
	private EstadoRepository estadoRepository;
	private PaisRepository paisRepository;
	
	public EstadoController(EstadoRepository estadoRepository, PaisRepository paisRepository) {
		this.estadoRepository = estadoRepository;
		this.paisRepository = paisRepository;
	}

	@PostMapping(value = "/estados")
	@Transactional
	public ResponseEntity<EstadoResponse> cadastraEstado(@RequestBody @Valid EstadoRequest request) {
		Estado estado = request.toModel(paisRepository);
		estado = estadoRepository.save(estado);
		EstadoResponse response  = new EstadoResponse(estado);
		return ResponseEntity.ok(response);
	}
	
}
