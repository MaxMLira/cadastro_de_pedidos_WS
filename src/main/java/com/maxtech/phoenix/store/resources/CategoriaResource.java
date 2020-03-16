package com.maxtech.phoenix.store.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.maxtech.phoenix.store.domain.Categoria;
import com.maxtech.phoenix.store.services.CategoriaService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria categoria =  service.buscar(id);
		
		
		return ResponseEntity.ok().body(categoria);
	}

	@PostMapping("")
	public ResponseEntity<Void> insert(@RequestBody  Categoria categoria){
		categoria = service.insert(categoria);
		URI url = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(categoria.getId()).toUri();

		return ResponseEntity.created(url).build();

	}

//	@DeleteMapping("/{id}")
//	public ResponseEntity<Void> delete(@PathVariable Integer id){
//		service.delete(id);
//	}
}
