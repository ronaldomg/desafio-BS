package br.com.bluesoft.desafio.integration.entity;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProdutoFornecedor {

  private String nome;
  private String cnpj;
  private ArrayList<Preco> precos;
  
  public ProdutoFornecedor(){
    this.nome = "";
    this.cnpj = "";
    this.precos = new ArrayList<>();
  }

  public ProdutoFornecedor(String nome, String cnpj, Preco preco){
    this.nome = nome;
    this.cnpj = cnpj;
    this.precos = new ArrayList<>();
    this.precos.add(preco);
  }

  public String getNome() {
    return nome;
  }

  public String getCnpj() {
    return cnpj;
  }

  public ArrayList<Preco> getPrecos() {
    return precos;
  }

  public void setNome(String nome){
      this.nome = nome;
  }

  public void setCnpj(String cnpj){
    this.cnpj = cnpj;
  }

  public void setPrecos(ArrayList<Preco> precos){
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
