package com.example.cursorspringjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
1. Створити проет Shops за допомогою Spring Boot,модель магазину містила такі поля
(айді, місто та вулиця де знаходиться магазин, назва магазину і кількість співробітників, та поле чи є у магазина сайт).
 Cтворити методи POST, GET  які приймають httpservletrequest та httpservletresponse та серіалізувати їх
 за допомогою Object Mapper( чи іншого інструменту наприклад Gson ) в java класи (а не спрінгом).
2. В проекті “Shops” використати патерн DTO де приховати кількість співробітників магазину.
		*/

@SpringBootApplication
public class CursorSpringJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursorSpringJpaApplication.class, args);
	}

}
