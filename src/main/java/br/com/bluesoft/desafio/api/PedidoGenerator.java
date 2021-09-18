package br.com.bluesoft.desafio.api;

import java.util.HashSet;

import br.com.bluesoft.desafio.integration.Cotacao;
import br.com.bluesoft.desafio.integration.entity.ProdutoFornecedor;
import br.com.bluesoft.desafio.model.Fornecedor;
import br.com.bluesoft.desafio.model.Pedido;
import br.com.bluesoft.desafio.model.Produto;
import br.com.bluesoft.desafio.model.ProdutoPedido;

public class PedidoGenerator {
    private HashSet<Pedido> pedidos = new HashSet<>();
    private HashSet<ProdutoPedido> produtos = new HashSet<>();
    private HashSet<Produto> produtosSemCotacao = new HashSet<>();

    public PedidoGenerator (HashSet<ProdutoPedido> produtos){
        this.produtos.addAll(produtos);
        this.pedidos.clear();
        createPedidos();
        if (produtosSemCotacao.size() > 0){
            pedidos.clear();
        }
    }

    public HashSet<Pedido> getPedidos(){
        return pedidos;
    }
    public HashSet<Produto> getProdutosSemCotacao(){
        return produtosSemCotacao;
    }

    private void createPedidos(){
        produtos.forEach(p->{
            Cotacao cotacao = new Cotacao(p);
            if (cotacao.getHasVencedor()){
                addPedidoFornecedor(p, cotacao.getVencedor());
            }else{
                produtosSemCotacao.add(p.getProduto());
            }
        });

    }

    private void addPedidoFornecedor(ProdutoPedido pp, ProdutoFornecedor pf){
        Pedido p = pedidos.stream()
        .filter(pedido -> pf.getCnpj().equals(pedido.getFornecedor().getCnpj()))
        .findAny()
        .orElse(new Pedido() );
        if (p.getFornecedor().getCnpj().equals(pf.getCnpj())){
            HashSet<ProdutoPedido> produtos = p.getProdutos();
                Float valorUN = pf.getPrecos().iterator().next().getPreco();
                pp.setValorUN(valorUN);
                pp.setPedido(p);
                produtos.add(pp);
                p.setProdutos(produtos);
        }else{
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setCNPJ(pf.getCnpj());
            fornecedor.setNome(pf.getNome());
            HashSet<ProdutoPedido> produtos = new HashSet<ProdutoPedido>();
            Float valorUN = pf.getPrecos().iterator().next().getPreco();
            pp.setValorUN(valorUN);
            produtos.add(pp);
            p.setFornecedor(fornecedor);
            p.setProdutos(produtos);
            pedidos.add(p);
        }
    }
   
}
