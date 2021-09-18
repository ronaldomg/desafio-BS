package br.com.bluesoft.desafio.integration.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProdutoFornecedor {

  private String nome;
  private String cnpj;
  private Set<Preco> precos = new HashSet<>();
  
  public ProdutoFornecedor(){
    this.nome = "";
    this.cnpj = "";
    this.precos = new HashSet<>();
  }

  public ProdutoFornecedor(String nome, String cnpj, Preco preco){
    this.nome = nome;
    this.cnpj = cnpj;
    this.precos = new HashSet<>();
    this.precos.add(preco);
  }

  public String getNome() {
    return nome;
  }

  public String getCnpj() {
    return cnpj;
  }

  public Set<Preco> getPrecos() {
    return precos;
  }

  public void setNome(String nome){
      this.nome = nome;
  }

  public void setCnpj(String cnpj){
    this.cnpj = cnpj;
  }

  public void setPrecos(Set<Preco> precos){
    this.precos = precos;
  }

  public boolean isEmpty(){
      if ((this.nome.equals("")) &&
      (this.cnpj.equals("")) &&
      (this.precos.size() == 0)){
          return true;
      }else{
          return false;
      }
  }
  @Override
  public String toString() {
    return "{" +
        "nome='" + nome + '\'' +
        ", cnpj='" + cnpj + '\'' +
        ", precos='" + precos + '\'' +
        '}';
  }


}
