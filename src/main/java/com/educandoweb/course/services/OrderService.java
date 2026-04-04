package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

//Implementando operação Buscar t users e users por ID
//Para isso OrderService tem q ter uma dependência p OrderRepository
@Service
public class OrderService {
	//@Autowired para o Spring fazer a Injeção de dependência transparênte
	//Declaração de dependência é o repository
	@Autowired
	private OrderRepository repository;
	
	//Método q retorna todos os usúarios tipo da lista é Order
	//Feito a operação na camada de serviço q é o findAll
	//Que repassa a chamada para repository.findAll()
	public List<Order> findAll(){
		return repository.findAll();
		
	}
	
	//Método q recupera user por id
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
