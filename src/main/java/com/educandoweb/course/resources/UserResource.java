package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;
//Camada de Recurso web, q depende da camada de serviços. Video 274 tempo 7:08
@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	//Colocando uma dependência no UserService. E @Autowired p fazer a inj de depen
	@Autowired
	private UserService service;
	
	@GetMapping
	//Testa o recurso User. com o metodo especifico do Spring o ResponseEntity
	//Que retorna respostas e requisições web
	//O tipo de resposta é a class User. E findAll é o nome do método.
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll() ;
		return ResponseEntity.ok().body(list);
		//no corpo da resposta recebe a variavél list
	}
	
	//Retorna user por id
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
