package br.com.alura.screenmatch.modelos;

public class Pessoa {
    private final String nome;
    private final int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String toString() {
        return "Pessoa: " + nome + " (Idade: " + idade + ")";
    }
}
