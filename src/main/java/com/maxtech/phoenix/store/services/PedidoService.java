package com.maxtech.phoenix.store.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxtech.phoenix.store.domain.Pedido;
import com.maxtech.phoenix.store.repositories.PedidoRepository;
import com.maxtech.phoenix.store.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido buscar(Integer id){
        Optional<Pedido> Pedido = pedidoRepository.findById(id);
        return  Pedido.orElseThrow(()->  new ObjectNotFoundException("Pedido não encontrado, Id: "+id));
    }
}
