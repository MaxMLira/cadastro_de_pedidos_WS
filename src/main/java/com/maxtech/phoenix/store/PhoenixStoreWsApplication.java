package com.maxtech.phoenix.store;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.maxtech.phoenix.store.domain.Categoria;
import com.maxtech.phoenix.store.domain.Cidade;
import com.maxtech.phoenix.store.domain.Cliente;
import com.maxtech.phoenix.store.domain.Endereco;
import com.maxtech.phoenix.store.domain.Estado;
import com.maxtech.phoenix.store.domain.Pagamento;
import com.maxtech.phoenix.store.domain.PagamentoComBoleto;
import com.maxtech.phoenix.store.domain.PagamentoComCartao;
import com.maxtech.phoenix.store.domain.Pedido;
import com.maxtech.phoenix.store.domain.Produto;
import com.maxtech.phoenix.store.domain.enums.EstadoPagamento;
import com.maxtech.phoenix.store.domain.enums.TipoCliente;
import com.maxtech.phoenix.store.repositories.CategoriaRepository;
import com.maxtech.phoenix.store.repositories.CidadeRepository;
import com.maxtech.phoenix.store.repositories.ClienteRepository;
import com.maxtech.phoenix.store.repositories.EnderecoRepository;
import com.maxtech.phoenix.store.repositories.EstadoRepository;
import com.maxtech.phoenix.store.repositories.PagamentoRepository;
import com.maxtech.phoenix.store.repositories.PedidoRepository;
import com.maxtech.phoenix.store.repositories.ProdutoRepository;

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
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PagamentoRepository pagRepo;
	@Autowired
	private PedidoRepository pedidoRepository;

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

		Cliente cleinte1 = new Cliente(null,"Maria Silva","maria@gmail.com","36378912377", TipoCliente.PESSOAFISICA);
		cleinte1.getTelefones().addAll(Arrays.asList("27363323","93838393"));
		Endereco end1 = new Endereco(null,"Rua flores","300","Apto 303","Jadim","38220834",cleinte1,c1);
		Endereco end2 = new Endereco(null,"Avenida Matos","105","Sala 800","Centro","38777012",cleinte1,c2);
		cleinte1.getEnderecos().addAll(Arrays.asList(end1,end2));

		clienteRepository.save(cleinte1);
		enderecoRepository.saveAll(Arrays.asList(end1,end2));
		
		
		/* pagamentos e pedidos talvez seja ao contrario*/
		
		
		Pedido pedi = new Pedido(null,LocalDateTime.of(2017,Month.SEPTEMBER, 30, 10, 32, 10),cleinte1,end1);
		
		Pedido ped2 = new Pedido(null,LocalDateTime.of(2017,Month.OCTOBER, 10, 19, 35, 00),cleinte1,end2);
		
		Pagamento pag1 = new PagamentoComCartao(null,EstadoPagamento.QUITADO,pedi,6);
		pedi.setPagamento(pag1);
		Pagamento pag2 = new PagamentoComBoleto(null,EstadoPagamento.PENDENTE,ped2,LocalDate.of(2017, Month.OCTOBER, 20), null);
		ped2.setPagamento(pag2);
		
		cleinte1.getPedidos().addAll(Arrays.asList(pedi,ped2));
		
		pedidoRepository.saveAll(Arrays.asList(pedi,ped2));
		pagRepo.saveAll(Arrays.asList(pag1,pag2));
		
		
		
		
		
		
		
		
		
		



	}
}
