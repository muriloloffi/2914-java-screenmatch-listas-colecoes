package br.com.alura.screenmatch.modelos;

import java.math.BigDecimal;

public class ContaBancaria implements Comparable<ContaBancaria> {
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
        return "%s, saldo: %.2f".formatted(
                this.numeroConta,
                this.getSaldo().doubleValue());
    }

    @Override
    public int compareTo(ContaBancaria outraConta) {
        return this.getSaldo().compareTo(outraConta.getSaldo());
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
