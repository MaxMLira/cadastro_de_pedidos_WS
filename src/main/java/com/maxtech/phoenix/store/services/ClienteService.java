package com.maxtech.phoenix.store.services;

import com.maxtech.phoenix.store.domain.Cliente;
import com.maxtech.phoenix.store.repositories.ClienteRepository;
import com.maxtech.phoenix.store.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente buscar(Integer id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return  cliente.orElseThrow(()->  new ObjectNotFoundException("Cliente não encontrado, Id: "+id));
    }
}
