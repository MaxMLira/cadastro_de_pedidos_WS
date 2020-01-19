package com.maxtech.phoenix.store.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxtech.phoenix.store.domain.Categoria;
import com.maxtech.phoenix.store.repositories.CategoriaRepository;


@Service
public class CategoriaService {
	
	
	@Autowired
	private CategoriaRepository repository;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> categoria = repository.findById(id);
		return categoria.orElse(null);
	}
}
