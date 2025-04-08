package br.com.alura.screenmatch.principal;

import java.math.BigDecimal;
import java.util.ArrayList;
import br.com.alura.screenmatch.modelos.Animal;
import br.com.alura.screenmatch.modelos.Cachorro;
import br.com.alura.screenmatch.modelos.Circulo;
import br.com.alura.screenmatch.modelos.ContaBancaria;
import br.com.alura.screenmatch.modelos.Forma;
import br.com.alura.screenmatch.modelos.Produto;
import br.com.alura.screenmatch.modelos.Quadrado;

public class PrincipalComExercicio {
    public static void main(String[] args) {
        ArrayList<String> stringArr = new ArrayList<>();
        stringArr.add("Texto1");
        stringArr.add("Texto2");
        stringArr.add("Texto3");

        stringArr.forEach(System.out::println);

        Cachorro cachorro1 = new Cachorro(true);
        Animal animal1 = cachorro1;
        System.out.println(animal1.isAlive());

        Animal animal = new Cachorro(true);
        if (animal instanceof Cachorro cachorro) {
            System.out.println(cachorro.isAlive());
        }

        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Macarrao", BigDecimal.valueOf(3.2), 2));
        produtos.add(new Produto("arroz", BigDecimal.valueOf(4.2), 3));

        double precoTotal = 0;
        int qntdades = 0;
        for (Produto produto : produtos) {
            precoTotal += produto.getPreco()
                    .multiply(new BigDecimal(produto.getQuantidade()))
                    .doubleValue();
            qntdades += produto.getQuantidade();
        }

        if (qntdades > 0) {
            System.out.println(precoTotal / qntdades);
        }

        Forma circulo = new Circulo(2);
        Forma quadrado = new Quadrado(4);

        circulo.calcularArea();
        quadrado.calcularArea();

        ArrayList<ContaBancaria> contasBancarias = new ArrayList<>();
        contasBancarias.add(new ContaBancaria("443322-5", BigDecimal.valueOf(43000.00)));
        contasBancarias.add(new ContaBancaria("948372-2", BigDecimal.valueOf(13000.00)));
        contasBancarias.add(new ContaBancaria("958372-2", BigDecimal.valueOf(12000.00)));
        contasBancarias.add(new ContaBancaria("946372-2", BigDecimal.valueOf(133000.00)));

        ContaBancaria contaBancariaMenorSaldo = null;
        for (ContaBancaria conta : contasBancarias) {
            if (contaBancariaMenorSaldo == null) {
                contaBancariaMenorSaldo = conta;
                continue;
            }
            if (conta.getSaldo().compareTo(contaBancariaMenorSaldo.getSaldo()) > 0) {
                contaBancariaMenorSaldo = conta;
            }
        }

        if (contaBancariaMenorSaldo != null) {
            System.out.println("A conta com o maior saldo é %s".formatted(contaBancariaMenorSaldo));
        }
    }
}
