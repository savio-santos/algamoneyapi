package com.savio.algamoneyapi.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.savio.algamoneyapi.model.enums.Perfil;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pessoa")
@NoArgsConstructor
@EqualsAndHashCode
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;

	@NotBlank(message = "não deve estar em branco e nem ser nulo")
	@Getter
	@Setter
	private String nome;

	@NotBlank(message = "não deve estar em branco e nem ser nulo")
	@Getter
	@Setter
	private String email;

	@JsonIgnore
	@NotBlank(message = "não deve estar em branco e nem ser nulo")
	@Getter
	@Setter
	private String senha;

	@NotNull(message = "não deve estar em branco e nem ser nulo")
	@Column(nullable = false)
	@Setter
	@Getter
	private Boolean ativo;

	@Embedded
	@Setter
	@Getter
	private Endereco endereco;

	@ElementCollection(fetch = FetchType.EAGER) // garante que o perfil seja buscado junto com o cliente
	@CollectionTable(name = "perfis")
	private Set<Integer> perfis = new HashSet<>();

	@Transient
	@JsonIgnore
	public boolean isInativo() {
		return !this.ativo;
	}

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}

}
