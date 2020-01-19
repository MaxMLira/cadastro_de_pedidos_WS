package com.maxtech.phoenix.store.repositories;

import com.maxtech.phoenix.store.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}
