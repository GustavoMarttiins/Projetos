package com.Generation.farmaciMartins.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	@Entity
	public class Produto {
		
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@NotNull(message = "Você não inseriu nenhum nome.")
	private String nome;
	
	@Column
	@NotNull(message = "Não há nenhum valor do produto")
	private double preco;
	
	@Column
	@NotNull(message = "É necessário uma descrição")
	private String descricao;

	public Produto() {
		super();
	}

	@ManyToOne
	@JsonIgnoreProperties ("produto")
	private Categoria categoria;
	
	public Produto(Long id,  String nome, String descricao, double preco) {
		
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
}
