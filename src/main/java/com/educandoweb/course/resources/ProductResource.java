package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.services.ProductService;
//Camada de Recurso web, q depende da camada de serviços. Video 274 tempo 7:08
@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	//Colocando uma dependência no ProductService. E @Autowired p fazer a inj de depen
	@Autowired
	private ProductService service;
		
	//Testa o recurso Product. com o metodo especifico do Spring o ResponseEntity
	//Que retorna respostas e requisições web
	//O tipo de resposta é a class Product. E findAll é o nome do método.
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll() ;
		return ResponseEntity.ok().body(list);
		//no corpo da resposta recebe a variavél list
	}
	
	//Retorna user por id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
