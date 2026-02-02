package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

//Implementando operação Buscar t users e users por ID
//Para isso UserService tem q ter uma dependência p UserRepository
@Service
public class UserService {
	//@Autowired para o Spring fazer a Injeção de dependência transparênte
	//Declaração de dependência é o repository
	@Autowired
	private UserRepository repository;
	
	//Método q retorna todos os usúarios tipo da lista é User
	//Feito a operação na camada de serviço q é o findAll
	//Que repassa a chamada para repository.findAll()
	public List<User> findAll(){
		return repository.findAll();
	}
	
	//Método q recupera user por id
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
}
