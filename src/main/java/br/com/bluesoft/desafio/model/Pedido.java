package br.com.bluesoft.desafio.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPedido;

    private Fornecedor fornecedor;
    @OneToMany
    private List<ProdutoPedido> produtos;

    public Integer getIdPedido(){
        return idPedido;
    }

    public Fornecedor getFornecedor(){
        return fornecedor;
    }

    public List<ProdutoPedido> getProdutos(){
        return produtos;
    }

    public void setIdPedido(Integer idPedido){
        this.idPedido = idPedido;
    }

    public void setFornecedor(Fornecedor fornecedor){
        this.fornecedor = fornecedor;
    }

    public void setProdutos(List<ProdutoPedido> produtos){
        this.produtos.addAll(produtos);
    }

}