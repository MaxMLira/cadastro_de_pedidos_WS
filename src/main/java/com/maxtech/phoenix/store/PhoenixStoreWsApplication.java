package com.maxtech.phoenix.store;

import com.maxtech.phoenix.store.domain.Categoria;
import com.maxtech.phoenix.store.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class PhoenixStoreWsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PhoenixStoreWsApplication.class, args);
	}
	@Autowired
	CategoriaRepository repository;

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		repository.saveAll(Arrays.asList(cat1,cat2));
	}
}
