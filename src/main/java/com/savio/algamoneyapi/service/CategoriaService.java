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
import com.savio.algamoneyapi.service.exception.ObjectNotFoundException;
@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Long id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "
		+ id + ", Tipo: " + Categoria.class.getName()));
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

	public void delete(Long id) {

		//try {
			find(id);
			repo.deleteById(id);

	//	} catch (DataIntegrityViolationException e) {
	//		throw new DataIntegrityViolationException("Não é póssivel excluir uma categoria que contém produtos.");
	//	}
	}

	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}



}
