package br.com.bluesoft.desafio.api;

import java.util.List;

import br.com.bluesoft.desafio.integration.ProdutoFornecedor;
import br.com.bluesoft.desafio.model.Pedido;
import br.com.bluesoft.desafio.model.ProdutoPedido;

public class PedidoGenerator {
    private List<Pedido> pedidos;
    private List<ProdutoPedido> produtos;

    public PedidoGenerator(List<ProdutoPedido> produtos){
        this.produtos.addAll(produtos);
        this.pedidos.clear();
        createPedidos();
    }

    private void createPedidos(){
        produtos.forEach(ProdutoPedido p ->{
            ProdutoFornecedor.
        });

    }
    
}
