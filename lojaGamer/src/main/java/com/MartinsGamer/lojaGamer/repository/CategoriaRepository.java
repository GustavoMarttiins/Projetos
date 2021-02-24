package com.MartinsGamer.lojaGamer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MartinsGamer.lojaGamer.models.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	public List <Categoria> findAllByGeneroJogosContainingIgnoreCase(String generoJogos);

}
