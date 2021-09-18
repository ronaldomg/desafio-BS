package br.com.bluesoft.desafio.integration.entity;

import java.util.HashSet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CotacaoProduto {
    
  private HashSet<ProdutoFornecedor> cotacoesProduto = new HashSet<>();

   public HashSet<ProdutoFornecedor> getCotacoesProduto() {
    return cotacoesProduto;
  }

  public void setCotacoesProduto(HashSet<ProdutoFornecedor> cotacoesProduto){
    this.cotacoesProduto = cotacoesProduto;
  }

  @Override
  public String toString() {
    String returnStr = "[";
    for (ProdutoFornecedor pf : cotacoesProduto){
      returnStr.concat(pf.toString()+",");
    }
    returnStr = returnStr.substring(0,returnStr.length()-1)+"]";
    return returnStr;
  }


}