package com.MartinsGamer.lojaGamer.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Usuarios {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long idUsuario;
	

	@Column
	@Size(min = 4, max = 50, message = "Insira um nome por favor.")
	private String nomeUsuario;
	
	
	@Column
	@Size(min = 4, max = 50, message = "Insira um endereço por favor.")
	private String endereco;
	
	
	@Column
	@Size(min = 4, max = 50, message = "Insira um email por favor.")
	private String email;
	
	
	@Column
	@Size(min = 4, max = 50, message = "Insira uma senha por favor.")
	private String senha;

	public Usuarios() {
		super();
	}

	public Usuarios(Long idUsuario, String nomeUsuario, String endereco, String email, String senha) {
		super();
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
		this.endereco = endereco;
		this.email = email;
		this.senha = senha;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
}
