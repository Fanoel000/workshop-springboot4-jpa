package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;

//Criado a classe especifica para testes
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner { //Ver interface CommandLineRunner
	//userRepository é um atributo do tipo classe UserRepository
	@Autowired
	private UserRepository userRepository; //
	
	//Salvar alguns pedidos na carga inicial do banco de cados => fazer o CID
	@Autowired
	private OrderRepository orderRepository;
	
	//Criar um mecanismo de injeção de dependencia 
	//Implícito automatico
	//para um objeto depender de outro
	//para associar uma instância do userRepository no caso os u1 e u2
	//no TestConfig usa o @Autowired
	
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");	
	
		//Padrão horario UTC, e pode converter p horario da região
		//Instant converte, u1 é associação entre objetos Ver esquema diagrama
		//Cria o primeiro pedido do usuário 1
		//Cria o segundo pedido do usuário 2
		//Cria o terceiro pedido do usuário 1
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:53:22Z"), u1);
		
		//salva os objetos, os usuarios u1 e u2. em um arrayList dentro Repository
    	//Arrays.asList => cria um arrayList e logo diz salve  as instâncias u1,u2
				userRepository.saveAll(Arrays.asList(u1, u2));
				
				orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	}
	

}
