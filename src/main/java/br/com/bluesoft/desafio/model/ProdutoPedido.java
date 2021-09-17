package br.com.bluesoft.desafio.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
public class ProdutoPedido {
    @ManyToOne
    @JoinColumn(name="idPedido", nullable=false)
    private Pedido pedido;
    private Produto produto;
    private Float quantidade;
    private Float valorUN;
    private Float valorTotal;

    public ProdutoPedido(Pedido pedido, Produto produto, Float quantidade, Float valorUN){
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorUN = valorUN;
        this.valorTotal = valorUN*quantidade;
    }

    public Pedido getPedido(){
        return pedido;
    }

    public Produto getProduto(){
        return produto;
    }

    public Float getQuantidade(){
        return quantidade;
    }

    public float getValorUN(){
        return valorUN;
    }

    public float getValorTotal(){
        return valorTotal;
    }

    public void setPedido(Pedido pedido){
        this.pedido = pedido;
    }

    public void setProduto(Produto produto){
        this.produto = produto;
    }

    public void setQuantidade(Float quantidade){
        this.quantidade = quantidade;
        setValorTotal();
    }

    public void setValorUN(Float valorUN){
        this.valorUN = valorUN;
        setValorTotal();
    }

    public void setValorTotal(){
        valorTotal = valorUN * quantidade;
    }
}
