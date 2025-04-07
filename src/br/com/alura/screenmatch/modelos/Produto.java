package br.com.alura.screenmatch.modelos;

import java.math.BigDecimal;

public class Produto {
  private String nome;
  private BigDecimal preco;
  private int quantidade;

  public Produto(String nome, BigDecimal preco, int quantidade) {
    this.setNome(nome);
    this.setPreco(preco);
    this.setQuantidade(quantidade);
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public BigDecimal getPreco() {
    return preco;
  }

  public void setPreco(BigDecimal preco) {
    this.preco = preco;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public String toString() {
    return "Produto: %s (Quantidade: %d)".formatted(this.getNome(), this.getQuantidade());
  }
}
