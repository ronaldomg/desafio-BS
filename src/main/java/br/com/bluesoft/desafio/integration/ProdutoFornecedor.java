package br.com.bluesoft.desafio.integration;

import org.springframework.web.client.RestTemplate;

public class ProdutoFornecedor {

	public static getCotacao(RestTemplate restTemplate) throws Exception {
			Quote quote = restTemplate.getForObject(
					"https://quoters.apps.pcfone.io/api/random", Quote.class);
			log.info(quote.toString());
		};
	}
}
