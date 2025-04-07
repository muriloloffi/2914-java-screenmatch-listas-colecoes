package br.com.alura.screenmatch.modelos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProdutoPerecivel extends Produto {
  private LocalDate dataValidade;

  public ProdutoPerecivel(String nome, BigDecimal preco, int quantidade, LocalDate dataValidade) {
    super(nome, preco, quantidade);
    this.setDataValidade(dataValidade);
  }

  public LocalDate getDataValidade() {
    return dataValidade;
  }

  public void setDataValidade(LocalDate dataValidade) {
    if (dataValidade.compareTo(LocalDate.now()) <= 0) {
      throw new RuntimeException("Data de validade menor ou igual à data atual.");
    }
    this.dataValidade = dataValidade;
  }

  @Override
  public String toString() {
    return "Produto: %s (Quantidade: %d; Validade: %s)".formatted(
      this.getNome(),
      this.getQuantidade(),
      this.getDataValidade().toString()
    );
  }
}
