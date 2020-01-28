package com.maxtech.phoenix.store.resources;

import com.maxtech.phoenix.store.domain.Cliente;
import com.maxtech.phoenix.store.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {
    @Autowired
    private ClienteService service;

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findOne(@PathVariable  Integer id){
        Cliente cliente = service.find(id);
        return ResponseEntity.status(HttpStatus.OK).body(cliente);
    }
}
