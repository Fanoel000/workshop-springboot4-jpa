package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

//Criado a classe especifica para testes
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner { //Ver interface CommandLineRunner
	//userRepository é um atributo do tipo classe UserRepository
	@Autowired
	private UserRepository userRepository; //
	
	//Criar um mecanismo de injeção de dependencia 
	//Implícito automatico
	//para um objeto depender de outro
	//para associar uma instância do userRepository no caso os u1 e u2
	//no TestConfig usa o @Autowired
	
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		//salva os objetos, os usuarios u1 e u2. 
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		
	}
	

}
