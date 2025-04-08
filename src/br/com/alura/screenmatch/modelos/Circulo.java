package br.com.alura.screenmatch.modelos;

public class Circulo implements Forma {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public void calcularArea() {
        System.out.println("Círculo de área %.3f".formatted(Math.PI * Math.pow(raio, 2)));
    }
}
