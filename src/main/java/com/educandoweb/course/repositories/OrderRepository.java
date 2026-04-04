package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.Order;
//Jpa pede qual é a Entidade e qual é sua id 
//User é o tipo da entidade p acessar, e Long é o tipo da chave dela
public interface OrderRepository extends JpaRepository<Order, Long>{

}
