package com.maxtech.phoenix.store;

import com.maxtech.phoenix.store.domain.Categoria;
import com.maxtech.phoenix.store.domain.Cidade;
import com.maxtech.phoenix.store.domain.Estado;
import com.maxtech.phoenix.store.domain.Produto;
import com.maxtech.phoenix.store.repositories.CategoriaRepository;
import com.maxtech.phoenix.store.repositories.CidadeRepository;
import com.maxtech.phoenix.store.repositories.EstadoRepository;
import com.maxtech.phoenix.store.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class PhoenixStoreWsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PhoenixStoreWsApplication.class, args);
	}
	@Autowired
	private CategoriaRepository repository;
	@Autowired
	private ProdutoRepository prodRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",80.00);
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat1.getProdutos().addAll(Arrays.asList(p2));
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		repository.saveAll(Arrays.asList(cat1,cat2));
		prodRepository.saveAll(Arrays.asList(p1,p2,p3));

		Estado esta1 = new Estado(null,"Minas Gerais");
		Estado esta2 = new Estado(null,"São Paulo");

		Cidade c1 = new Cidade(null,"Uberlândia",esta1);
		Cidade c2 = new Cidade(null,"São Paulo",esta2);
		Cidade c3 = new Cidade(null,"Campinas",esta2);

		esta1.getCidades().addAll(Arrays.asList(c1));
		esta2.getCidades().addAll(Arrays.asList(c2,c3));
		estadoRepository.saveAll(Arrays.asList(esta1,esta2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
	}
}
