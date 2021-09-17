package br.com.bluesoft.desafio.model;

import javax.persistence.Entity;

@Entity
public class ProdutoPedido {
    private Produto produto;
    private Float quantidade;
    private Float valorUN;
    private Float valorTotal;

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
