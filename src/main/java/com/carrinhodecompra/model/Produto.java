package com.carrinhodecompra.model;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
@SequenceGenerator(name = "produtos_seq", allocationSize = 1)
public class Produto {
    
    @Id
    @Column(name = "id_produtos")
    @GeneratedValue(generator = "produtos_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "preco")
    private Double preco;
    
    @Column(name = "quantidade")
    private Long quantidade;

    @Column(name = "total")
    private Double total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id) &&
                Objects.equals(descricao, produto.descricao) &&
                Objects.equals(preco, produto.preco) &&
                Objects.equals(quantidade, produto.quantidade) &&
                Objects.equals(total, produto.total);
    }
}
