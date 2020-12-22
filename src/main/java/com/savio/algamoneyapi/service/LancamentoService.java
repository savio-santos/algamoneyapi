package com.savio.algamoneyapi.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.savio.algamoneyapi.model.Lancamento;
import com.savio.algamoneyapi.repository.LancamentoRepository;
import com.savio.algamoneyapi.service.exception.ObjectNotFoundException;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository repo;

	public Lancamento find(Long id) {
		Optional<Lancamento> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Lancamento.class.getName()));
	}

	public List<Lancamento> findAll() {
		return repo.findAll();
	}

	@Transactional
	public Lancamento insert(Lancamento obj) {

		return repo.save(obj);

	}

	public Lancamento update(Lancamento obj) {
		Lancamento cat = find(obj.getId());
		// falta implementar
		return repo.save(obj);

	}

	public void delete(Long id) {

		// try {
		find(id);
		repo.deleteById(id);

		// } catch (DataIntegrityViolationException e) {
		// throw new DataIntegrityViolationException("Não é póssivel excluir uma
		// categoria que contém produtos.");
		// }
	}

	public Page<Lancamento> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

}
