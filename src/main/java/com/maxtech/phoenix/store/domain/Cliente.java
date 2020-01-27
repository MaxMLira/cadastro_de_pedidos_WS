package com.maxtech.phoenix.store.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.maxtech.phoenix.store.domain.enums.TipoCliente;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;
    @Getter @Setter
    private String nome;
    @Getter @Setter
    private String email;
    @Getter @Setter
    private String cpfOrCnpj;
    private Integer tipoCliente;

    @Getter @Setter
    @OneToMany(mappedBy = "cliente")
    @JsonManagedReference
    private List<Endereco> enderecos = new ArrayList<>();
    @Getter @Setter
    @ElementCollection
    @CollectionTable(name = "TELEFONE")
    private Set<String> telefones = new HashSet<>();
    
    @OneToMany(mappedBy = "cliente")
    @Getter @Setter
    @JsonBackReference
    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente(Integer id, String nome, String email, String cpfOrCnpj, TipoCliente tipoCliente) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpfOrCnpj = cpfOrCnpj;
        this.tipoCliente = tipoCliente.getCod();
    }

    public TipoCliente getTipoCliente() {
        return TipoCliente.toEnum(this.tipoCliente);
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente.getCod();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id.equals(cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
