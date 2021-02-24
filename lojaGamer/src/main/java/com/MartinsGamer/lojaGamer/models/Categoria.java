package com.MartinsGamer.lojaGamer.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
public class Categoria {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idCategoria;

	@Column
	@NotNull(message = "Ops, é necessário informar o seu genero!")
	private String generoJogos;

	public Categoria() { 

	}
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List <Produto> produto;

	public Categoria(Long idCategoria, String generoJogos) {

		this.idCategoria = idCategoria;
		this.generoJogos = generoJogos;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getGeneroJogos() {
		return generoJogos;
	}

	public void setGeneroJogos(String generoJogos) {
		this.generoJogos = generoJogos;
	}

	
}
