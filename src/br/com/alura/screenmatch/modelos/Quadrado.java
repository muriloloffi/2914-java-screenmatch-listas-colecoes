package br.com.alura.screenmatch.modelos;

public class Quadrado implements Forma {
    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    public void calcularArea() {
        System.out.println("Quadrado de área %.2f".formatted(lado * lado));
    }
}
