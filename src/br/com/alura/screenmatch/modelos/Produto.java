package br.com.alura.screenmatch.modelos;

import java.math.BigDecimal;

public class Produto implements Comparable<Produto> {
    private String nome;
    private BigDecimal preco;
    private int quantidade;

    public Produto(String nome, Double preco) {
        this.setNome(nome);
        this.setPreco(BigDecimal.valueOf(preco.doubleValue()));
    }

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
        if (this.getQuantidade() != 0) {
            return "Produto: %s (Quantidade: %d)".formatted(this.getNome(), this.getQuantidade());
        }
        return this.getNome() + " - " + this.getPreco().doubleValue();
    }

    @Override
    public int compareTo(Produto outroProduto) {
        return this.getPreco().compareTo(outroProduto.getPreco());
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
