package com.savio.algamoneyapi.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.savio.algamoneyapi.model.enums.TipoLancamento;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Lancamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	
	@Column(name = "data_vencimento")
	private LocalDate dataVencimento;
	
	@Column(name = "data_pagamento")
	private LocalDate dataPagamento;
	
	private BigDecimal valor;
	
	private String observacao;
	
	@Enumerated(EnumType.STRING)
	private TipoLancamento tipo;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;
	
	

}
