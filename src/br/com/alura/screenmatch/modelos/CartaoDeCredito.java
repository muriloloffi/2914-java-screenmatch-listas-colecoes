package br.com.alura.screenmatch.modelos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartaoDeCredito {
    private BigDecimal limite;
    private BigDecimal saldo;
    private List<Produto> produtos;

    public CartaoDeCredito() {
        this.produtos = new ArrayList<>();
    }

    public CartaoDeCredito(Double limite) {
        this.limite = BigDecimal.valueOf(limite);
        this.saldo = BigDecimal.valueOf(limite);
        this.produtos = new ArrayList<>();
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public List<Produto> getProdutos() {
        Collections.sort(this.produtos);
        return this.produtos;
    }

    public boolean lancaCompra(Produto produto) {
        if (this.saldo.compareTo(produto.getPreco()) < 0) {
            System.out.println("Saldo insuficiente");
            return false;
        }
        if (this.produtos.contains(produto)) {
            System.out.println("Produto já adicionado");
            return false;
        }
        this.produtos.add(produto);
        this.saldo = this.saldo.subtract(produto.getPreco());
        return true;
    }
}
