package br.com.bluesoft.desafio.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ProdutoPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idPedido", nullable = false)
    private Pedido pedido;
    // private Integer idPedido;
    // @Id
    //private String produtoGtin;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gtin", nullable = false)
    private Produto produto;
    private Float quantidade;
    private Float valorUN;
    private Float valorTotal;


    public Produto getProduto(){
        return produto;
    }
    public void setProduto(Produto produto){
        this.produto = produto;
    }
    // public String getProdutoGtin(){
    //     return produtoGtin;
    // }
    // public void setProdutoGtin(String produtoGtin){
    //     this.produtoGtin = produtoGtin;
    // }
    // public Integer getIdPedido(){
    //     return idPedido;
    // }

    // public void setIdPedido(Integer idPedido){
    //     this.idPedido = idPedido;
    // }
    public Pedido getPedido(){
        return pedido;
    }

    public void setPedido(Pedido pedido){
        this.pedido = pedido;
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
