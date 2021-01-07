package com.savio.algamoneyapi.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.savio.algamoneyapi.model.Lancamento;
import com.savio.algamoneyapi.model.Pessoa;
import com.savio.algamoneyapi.repository.LancamentoRepository;
import com.savio.algamoneyapi.repository.filter.LancamentoFilter;
import com.savio.algamoneyapi.service.exception.ObjectNotFoundException;
import com.savio.algamoneyapi.service.exception.PessoaInativaException;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository repo;

	@Autowired
	private PessoaService pessoaService;

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
		Pessoa pessoa = pessoaService.find(obj.getPessoa().getId());
		if (pessoa.isInativo()) {
			throw new PessoaInativaException("Pessoa Inativa");

		}
		
		return repo.save(obj);
	}

	public Lancamento update(Lancamento obj) {
		find(obj.getId());
		return repo.save(obj);

	}

	public void delete(Long id) {
		
		find(id);
		repo.deleteById(id);
		
	}

	public Page<Lancamento> search(LancamentoFilter filter, Pageable pageable) {
		return repo.filtrar(filter,pageable);
	}

//	public Page<Lancamento> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
//
//		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
//		return repo.findAll(pageRequest);
//	}

}
