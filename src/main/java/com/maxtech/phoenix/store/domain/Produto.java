package com.maxtech.phoenix.store.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Double preco;
    @OneToMany(mappedBy = "id.produto")
    private Set<ItemPedido> itens = new HashSet<>();

    @JsonBackReference
    @ManyToMany
    @JoinTable(
            name="PRODUTO_CATEGORIA",
            joinColumns = @JoinColumn(name="produto_id"),
            inverseJoinColumns = @JoinColumn(name="categoria_id")
    )
    private List<Categoria> categorias = new ArrayList<>();

    public Produto(Integer id,String nome,Double preco){
        this.id= id;
        this.nome = nome;
        this.preco = preco;
    }
    
    public List<Pedido> getPedidos(){
    	List<Pedido> lista = new ArrayList<>();
    	itens.forEach(item->{
    		lista.add(item.getPedido());
    	});
    	return lista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return id.equals(produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
