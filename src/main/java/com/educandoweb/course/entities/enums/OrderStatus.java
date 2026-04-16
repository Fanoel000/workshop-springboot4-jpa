package com.educandoweb.course.entities.enums;

public enum OrderStatus {
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	//Construtor declarado + get p percorrer
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
		
	//Método Statico sem precisar instânciar retorno Objeto do tipo OrderStatus
	//Converte um valor númerico p valor Enumerado

	public static OrderStatus valueOf(int code) {
		//Irá percorrer todos OrderStatus acima do 1 a 5
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code)
				return value;
		}
		//Lança uma excessão caso o número não seja de 1 a 5
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}




