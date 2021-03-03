package com.savio.algamoneyapi.resource;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.savio.algamoneyapi.event.RecursoCriadoEvent;
import com.savio.algamoneyapi.model.Lancamento;
import com.savio.algamoneyapi.repository.filter.LancamentoFilter;
import com.savio.algamoneyapi.service.LancamentoService;

@RestController
@RequestMapping(value = "/lancamentos")
public class LancamentoResource {

	@Autowired
	LancamentoService lancamentoService;

	@Autowired
	private ApplicationEventPublisher publisher; // responsavel por pegar o evando de criação de recurso

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Lancamento>> findById(@PathVariable Long id) {

		Optional<Lancamento> obj = Optional.of(lancamentoService.find(id));

		if (obj.isPresent()) {
			return ResponseEntity.ok(obj);
		}

		else {
			return ResponseEntity.notFound().build();
		}
	}

//	@GetMapping
//	public ResponseEntity<List<Lancamento>> findAll() {
//		List<Lancamento> list = lancamentoService.findAll();
//		return ResponseEntity.ok().body(list);

	
	@GetMapping()
	public Page<Lancamento> pesquisar(LancamentoFilter filter, Pageable pageable) {
		return lancamentoService.search( filter, pageable);
		
	}
	

	@PostMapping
	public ResponseEntity<Lancamento> insert(@Valid @RequestBody Lancamento obj, HttpServletResponse response) {
		obj = lancamentoService.insert(obj);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, obj.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(obj);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Lancamento> delete(@PathVariable Long id) {
		lancamentoService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
