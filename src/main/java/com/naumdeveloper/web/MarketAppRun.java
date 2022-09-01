package com.naumdeveloper.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarketAppRun {

	public static void main(String[] args) {
		SpringApplication.run(MarketAppRun.class, args);
	}
}

/*
Урок 8. Thymeleaf
Задание
1. Сделайте страницу для отображения всех товаров.
2. Рядом с каждым товаром в таблице попробуйте сделать кнопку “Удалить”, при нажатии на которую товар должен быть удален и базы.
3. * Попробуйте реализовать разбивку всех товаров на страницы, по 10 товаров на каждой.
 */