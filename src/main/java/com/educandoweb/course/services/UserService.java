package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.resources.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
	public List<User> findAll(){ //==> diz vou entregar uma lista tipo User
		return repository.findAll(); //==> Busca a lista no repositorio
		
	}
	
	//Método q recupera user por id
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id)); 
	}
	
	//Inserir no banco de dados um novo obj do tipo User
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
		repository.deleteById(id);
		
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		try {
			User entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	//Obs: Não se atualiza id e senhas.
	private void updateData(User entity, User obj) {
		
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
		
	}
}
