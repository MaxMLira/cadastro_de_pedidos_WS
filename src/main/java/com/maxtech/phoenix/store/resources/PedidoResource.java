package com.maxtech.phoenix.store.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxtech.phoenix.store.domain.Pedido;
import com.maxtech.phoenix.store.services.PedidoService;


@RestController
@RequestMapping("/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Pedido categoria =  service.buscar(id);
		
		
		return ResponseEntity.ok().body(categoria);
	}
}
