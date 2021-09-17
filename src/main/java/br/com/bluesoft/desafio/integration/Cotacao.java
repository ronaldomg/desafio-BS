package br.com.bluesoft.desafio.integration;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import br.com.bluesoft.desafio.integration.entity.CotacaoProduto;
import br.com.bluesoft.desafio.integration.entity.ProdutoFornecedor;
import br.com.bluesoft.desafio.model.ProdutoPedido;

public class Cotacao {
	private ProdutoFornecedor vencedor;
	private Float melhorPreco;
	private ProdutoPedido produtoPedido;
	private Boolean hasVencedor;
	
	public Cotacao(ProdutoPedido produtoPedido){
		this.produtoPedido = produtoPedido;
		RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
		RestTemplate restTemplate = restTemplateBuilder.build();
		CotacaoProduto cotacaoProduto = restTemplate.getForObject(
			"https://egf1amcv33.execute-api.us-east-1.amazonaws.com/dev/produto/"+
			produtoPedido.getProduto().getGtin(), CotacaoProduto.class);
		defineVencedor(cotacaoProduto);
	}

	private void defineVencedor(CotacaoProduto cotacaoProduto){
		this.hasVencedor = false;
		cotacaoProduto.getCotacoesProduto().forEach(pf->{
			pf.getPrecos().forEach(p->{
				if (p.getQuantidadeMinima() >= produtoPedido.getQuantidade()){
					if((melhorPreco == 0f)||(melhorPreco > p.getPreco())){
						melhorPreco = p.getPreco();
						vencedor = new ProdutoFornecedor(pf.getNome(),pf.getCnpj(),p);
						this.hasVencedor = true;
					}
				}
			});			
		});
	}

	public ProdutoFornecedor getVencedor(){
		return this.vencedor;
	}

	public Boolean getHasVencedor(){
		return hasVencedor;
	}

}
