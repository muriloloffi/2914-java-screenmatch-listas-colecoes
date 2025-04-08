package br.com.alura.screenmatch.modelos;

import java.math.BigDecimal;

public class ContaBancaria {
    private String numeroConta;
    private BigDecimal saldo;

    public ContaBancaria(String nrConta, BigDecimal saldo) {
        this.numeroConta = nrConta;
        this.saldo = saldo;
    }

    public BigDecimal getSaldo() {
        return this.saldo;
    }

    public String toString() {
        return "%s, saldo: %.2f".formatted(this.numeroConta, this.getSaldo().doubleValue());
    }
}
