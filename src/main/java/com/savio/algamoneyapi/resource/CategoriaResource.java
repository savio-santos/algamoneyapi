package com.savio.algamoneyapi.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.savio.algamoneyapi.model.Categoria;
import com.savio.algamoneyapi.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	CategoriaService categoriaService;

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> find(@PathVariable Integer id) {

		Optional<Categoria> obj = Optional.of(categoriaService.find(id));

		return obj.isPresent()?  ResponseEntity.ok(obj.get()): ResponseEntity.notFound().build();
	}

	@GetMapping
	public ResponseEntity<List<Categoria>> findAll() {
		List<Categoria> list = categoriaService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Categoria> insert(@RequestBody Categoria obj) {
		obj = categoriaService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj); // boas praticas rest para retornar o caminho do obj criado
	}
	


}
