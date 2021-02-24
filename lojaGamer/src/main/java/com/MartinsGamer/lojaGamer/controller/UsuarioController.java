package com.MartinsGamer.lojaGamer.controller;

import java.util.List;

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
import com.MartinsGamer.lojaGamer.models.Usuarios;
import com.MartinsGamer.lojaGamer.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;

	@GetMapping
	public ResponseEntity<List<Usuarios>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuarios> GetById(@PathVariable Long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/departamento/{departamento}")
	public ResponseEntity<Object> GetByTitulo(@PathVariable String nomeUsuario) {
		return ResponseEntity.ok(repository.findAllByNomeUsuarioContainingIgnoreCase(nomeUsuario));
	}

	@PostMapping
	public ResponseEntity<Usuarios> Post(@RequestBody Usuarios nomeUsuairo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(nomeUsuairo));
	}

	@PutMapping
	public ResponseEntity<Usuarios> Put(@RequestBody Usuarios nomeUsuairo) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(nomeUsuairo));
	}

	@DeleteMapping("/{id}")
	public void Delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
