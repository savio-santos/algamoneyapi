package com.savio.algamoneyapi.repository.lancamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.savio.algamoneyapi.model.Lancamento;
import com.savio.algamoneyapi.repository.filter.LancamentoFilter;

public interface lancamentoRepositoryQuery{

	public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter,Pageable pageable);
}
