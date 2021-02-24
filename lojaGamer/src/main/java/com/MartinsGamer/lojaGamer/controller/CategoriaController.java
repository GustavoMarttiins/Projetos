package com.MartinsGamer.lojaGamer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MartinsGamer.lojaGamer.models.Categoria;
import com.MartinsGamer.lojaGamer.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {

	@Autowired // Injetando a dependencia do repositorio
	private CategoriaRepository repositoryCategoria;

	@GetMapping
	public ResponseEntity<List<Categoria>> GetAll() {
		return ResponseEntity.ok(repositoryCategoria.findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<Categoria> GetById(@PathVariable Long id) {
		return repositoryCategoria.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/generoJogos/{generosJogos}")
	public ResponseEntity<Object> GetByTitulo(@PathVariable String generoJogos){
		return ResponseEntity.ok(repositoryCategoria.findAllByGeneroJogosContainingIgnoreCase (generoJogos));
	}
	
	@PostMapping
	public ResponseEntity<Categoria> Post (@Valid @RequestBody Categoria categoria){ //@valid vai verificar se é valido.
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryCategoria.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<Categoria> Put (@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.OK).body(repositoryCategoria.save(categoria));
	}
	
	@DeleteMapping("/{id}")
	public void Delete (@PathVariable Long id) {
		repositoryCategoria.deleteById(id);
	}
}
