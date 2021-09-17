package br.com.bluesoft.desafio.integration.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Preco {

  private Float preco;
  private Float quantidade_minima;

  public Float getPreco(){
    return preco;
  }

  public Float getQuantidadeMinima(){
    return quantidade_minima;
  }

  public void setPreco(Float preco){
    this.preco = preco;
  }

  public void setQuantidadeMinima(Float qtdMin){
    this.quantidade_minima = qtdMin;
  }

  @Override
  public String toString() {
    return "{" +
        "valor='" + preco + '\'' +
        ", quantidade_minima='" + quantidade_minima + '\'' +
        '}';
  }

}
