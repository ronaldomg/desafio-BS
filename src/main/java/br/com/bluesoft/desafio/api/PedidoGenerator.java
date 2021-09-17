package br.com.bluesoft.desafio.api;

import java.util.ArrayList;
import java.util.List;


import br.com.bluesoft.desafio.integration.Cotacao;
import br.com.bluesoft.desafio.integration.entity.ProdutoFornecedor;
import br.com.bluesoft.desafio.model.Fornecedor;
import br.com.bluesoft.desafio.model.Pedido;
import br.com.bluesoft.desafio.model.Produto;
import br.com.bluesoft.desafio.model.ProdutoPedido;
import br.com.bluesoft.desafio.repository.PedidoRepository;
import br.com.bluesoft.desafio.view.ErroView;

public class PedidoGenerator {
    private List<Pedido> pedidos;
    private List<ProdutoPedido> produtos;
    private List<Produto> produtosSemCotacao;

    public PedidoGenerator(List<ProdutoPedido> produtos){
        this.produtos.addAll(produtos);
        this.pedidos.clear();
        createPedidos();
        if (produtosSemCotacao.size() > 0){
            pedidos.clear();
        }
    }

    public List<Pedido> getPedidos(){
        return pedidos;
    }
    public List<Produto> getProdutosSemCotacao(){
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
        Integer pedidoId = 0;
        Pedido p = pedidos.stream()
        .filter(pedido -> pf.getCnpj().equals(pedido.getFornecedor().getCnpj()))
        .findAny()
        .orElse(new Pedido() );
        if (p.getFornecedor().getCnpj().equals(pf.getCnpj())){
                List<ProdutoPedido> produtos = p.getProdutos();
                Float valorUN = pf.getPrecos().listIterator().next().getPreco();
                pp.setValorUN(valorUN);
                pp.setPedido(p);
                produtos.add(pp);
                p.setProdutos(produtos);
                pedidoId = p.getIdPedido();
        }else{
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setCNPJ(pf.getCnpj());
            fornecedor.setNome(pf.getNome());
            ArrayList<ProdutoPedido> produtos = new ArrayList<ProdutoPedido>();
            Float valorUN = pf.getPrecos().listIterator().next().getPreco();
            pp.setValorUN(valorUN);
            produtos.add(pp);
            p.setFornecedor(fornecedor);
            p.setProdutos(produtos);
            pedidos.add(p);
        }
    }
    
    private class CotacaoException extends Exception{
		String message;
		public CotacaoException (String message){
			this.message = message;
		}
	}

}
