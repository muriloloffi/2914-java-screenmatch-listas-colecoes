package br.com.alura.screenmatch.modelos;

public class Animal {
    private boolean isAlive;

    public Animal(boolean isAlive) {
        this.setAlive(isAlive);
    }

    public boolean isAlive() {
        return isAlive;
}

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
}
