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
    private Float valor;
}
