package com.maxtech.phoenix.store.repositories;

import com.maxtech.phoenix.store.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Integer> {

}
