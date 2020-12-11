package com.savio.algamoneyapi.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.savio.algamoneyapi.model.Categoria;
import com.savio.algamoneyapi.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.get();

	}

	public List<Categoria> findAll() {
		return repo.findAll();
	}

	@Transactional
	public Categoria insert(Categoria obj) {

		return repo.save(obj);

	}

	public Categoria update(Categoria obj) {
		Categoria cat = find(obj.getId());
		cat.setNome(obj.getNome());
		return repo.save(obj);

	}

	public void delete(Integer id) {

		find(id);
		repo.deleteById(id);

	}

	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}



}
