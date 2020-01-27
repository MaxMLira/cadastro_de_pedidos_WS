package com.maxtech.phoenix.store.domain;

import javax.persistence.Entity;

import com.maxtech.phoenix.store.domain.enums.EstadoPagamento;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class PagamentoComCartao extends Pagamento  {
	
	
	private static final long serialVersionUID = 1L;
	private Integer numParcelas;

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedi, Integer numParcelas) {
		super(id,estado.getCod(),pedi);
		this.numParcelas = numParcelas;
	}
	
	
}
