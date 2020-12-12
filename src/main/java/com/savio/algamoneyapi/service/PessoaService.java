package com.savio.algamoneyapi.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.savio.algamoneyapi.model.Pessoa;
import com.savio.algamoneyapi.repository.PessoaRepository;
import com.savio.algamoneyapi.service.exception.ObjectNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repo;

	public Pessoa find(Long id) {
		Optional<Pessoa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pessoa.class.getName()));
	}

	public List<Pessoa> findAll() {
		return repo.findAll();
	}

	@Transactional
	public Pessoa insert(Pessoa obj) {

		return repo.save(obj);

	}

	public Pessoa update(Pessoa obj) {
		Pessoa cat = find(obj.getId());
		cat.setNome(obj.getNome());
		return repo.save(obj);

	}

	public void delete(Long id) {

		find(id);
		repo.deleteById(id);

	}

	public Page<Pessoa> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

}
