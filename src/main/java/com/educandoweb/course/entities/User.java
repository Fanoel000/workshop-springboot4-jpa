package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;

	//Associação um User tem vários pedidos. associação muitos p um
	@OneToMany(mappedBy = "client")
	private List<Order> orders = new ArrayList<>();
	
	public User() {
	}

	public User(Long id, String name, String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
		
	public List<Order> getOrders() {
		return orders;
	}
	
	//hashCode, serve Transformar um objeto em um número inteiro único
	//Esse número serve organizar e encontrar objetos mais rápido
	@Override
	public int hashCode() {
		final int prime = 31; //padrão 31 evita erros
		int result = 1; //inicio
		//operador ternário. Se id for nulo → use 0 ou id.hashCode().
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) //igualdade de objetos na memoria = true
			return true;
		if (obj == null) //objeto = null => false
			return false;
		if (getClass() != obj.getClass())//verifica se os dois objetos são do mesmo "tipo"
			return false;
		
		//Casting de obj para User => Assume valores da classe User
		User other = (User) obj;//User da propria classe é um casting
		if (id == null) {
			if (other.id != null)//se id for null e id dif nulo logo false
				return false;
		} else if (!id.equals(other.id))//“Senão, se o meu ID for diferente do ID do outro usuário…”
			return false;
		return true; //Os IDs não são diferentes — ou seja, são iguais (ou ambos são null).
	}

	
}
