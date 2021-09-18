package br.com.bluesoft.desafio.model;

import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPedido;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cnpj", nullable = false)
    private Fornecedor fornecedor;
    @OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private HashSet<ProdutoPedido> produtos = new HashSet<>();

    public Integer getIdPedido(){
        return idPedido;
    }

    public Fornecedor getFornecedor(){
        return fornecedor;
    }

    public HashSet<ProdutoPedido> getProdutos(){
        return produtos;
    }

    public void setIdPedido(Integer idPedido){
        this.idPedido = idPedido;
    }

    public void setFornecedor(Fornecedor fornecedor){
        this.fornecedor = fornecedor;
    }

    public void setProdutos(HashSet<ProdutoPedido> produtos){
        this.produtos.addAll(produtos);
    }

}
