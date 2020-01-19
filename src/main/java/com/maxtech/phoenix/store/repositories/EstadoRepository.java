package com.maxtech.phoenix.store.repositories;

import com.maxtech.phoenix.store.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado,Integer> {
}
