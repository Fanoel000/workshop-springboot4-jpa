package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;

//Implementando operação Buscar t users e users por ID
//Para isso ProductService tem q ter uma dependência p ProductRepository
@Service
public class ProductService {
	//@Autowired para o Spring fazer a Injeção de dependência transparênte
	//Declaração de dependência é o repository
	@Autowired
	private ProductRepository repository;
	
	//Método q retorna todos os usúarios tipo da lista é Product
	//Feito a operação na camada de serviço q é o findAll
	//Que repassa a chamada para repository.findAll()
	public List<Product> findAll(){
		return repository.findAll();
		
	}
	
	//Método q recupera user por id
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
}
