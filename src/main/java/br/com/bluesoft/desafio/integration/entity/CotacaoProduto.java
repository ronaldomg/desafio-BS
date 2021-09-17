package br.com.bluesoft.desafio.integration.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CotacaoProduto {
    
  private List<ProdutoFornecedor> cotacoesProduto;

   public List<ProdutoFornecedor> getCotacoesProduto() {
    return cotacoesProduto;
  }

  public void setCotacoesProduto(List<ProdutoFornecedor> cotacoesProduto){
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