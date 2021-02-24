package com.MartinsGamer.lojaGamer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MartinsGamer.lojaGamer.models.Usuarios;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
	public List<Usuarios> findAllByNomeUsuarioContainingIgnoreCase(String nomeUsuario);
}
