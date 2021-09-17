package br.com.bluesoft.desafio.integration.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProdutoFornecedor {



  private String nome;
  private String cnpj;
  private Preco value;

  public Quote() {
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Value getValue() {
    return value;
  }

  public void setValue(Value value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "Quote{" +
        "type='" + type + '\'' +
        ", value=" + value +
        '}';
  }
}COPY

}
