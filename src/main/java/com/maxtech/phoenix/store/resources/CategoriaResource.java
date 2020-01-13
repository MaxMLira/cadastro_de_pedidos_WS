package com.maxtech.phoenix.store.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxtech.phoenix.store.domain.Categoria;


@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	@GetMapping("")
	public  List<Categoria> teste() {
		Integer i = 90;
		Categoria  c = new Categoria(i,"Informatica");
		Categoria  c2 = new Categoria(i,"Ingles");
		List<Categoria> cl = new ArrayList<>();
		cl.add(c);
		cl.add(c2);
		
		
		return cl;
	}
}
