package com.savio.algamoneyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.savio.algamoneyapi.model.Lancamento;
import com.savio.algamoneyapi.repository.lancamento.lancamentoRepositoryQuery;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, lancamentoRepositoryQuery{

	
}
