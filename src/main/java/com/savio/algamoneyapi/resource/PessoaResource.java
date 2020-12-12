package com.savio.algamoneyapi.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
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
import com.savio.algamoneyapi.model.Pessoa;
import com.savio.algamoneyapi.service.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

	@Autowired
	PessoaService pessoaService;

	@Autowired
	private ApplicationEventPublisher publisher; // responsavel por pegar o evando de criação de recurso

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Pessoa>> findById(@PathVariable Long id) {

		Optional<Pessoa> obj = Optional.of(pessoaService.find(id));

		if (obj.isPresent()) {
			return ResponseEntity.ok(obj);
		}

		else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll() {
		List<Pessoa> list = pessoaService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<Pessoa> insert(@Valid @RequestBody Pessoa obj, HttpServletResponse response) {
		obj = pessoaService.insert(obj);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, obj.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(obj);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Pessoa> delete(@PathVariable Long id) {
		pessoaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
