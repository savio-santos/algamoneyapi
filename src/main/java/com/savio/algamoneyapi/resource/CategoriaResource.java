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
import com.savio.algamoneyapi.model.Categoria;
import com.savio.algamoneyapi.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	CategoriaService categoriaService;

	@Autowired
	private ApplicationEventPublisher publisher; // responsavel por pegar o evando de criação de recurso

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Categoria>> findById(@PathVariable Long id) {

		Optional<Categoria> obj = Optional.of(categoriaService.find(id));

		if (obj.isPresent()) {
			return ResponseEntity.ok(obj);
		}

		else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public ResponseEntity<List<Categoria>> findAll() {
		List<Categoria> list = categoriaService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<Categoria> insert(@Valid @RequestBody Categoria obj, HttpServletResponse response) {
		obj = categoriaService.insert(obj);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, obj.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(obj);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Categoria> delete(@PathVariable Long id) {
		categoriaService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
