package br.com.alura.screenmatch.principal;

import java.util.Scanner;
import br.com.alura.screenmatch.modelos.CartaoDeCredito;
import br.com.alura.screenmatch.modelos.Produto;

public class PrincipalDesafio {

    public static void main(String[] args) {
        final String USER_INTENTION_REQUEST = "Digite 0 para sair ou 1 para continuar";
        Scanner scanner = new Scanner(System.in);
        CartaoDeCredito cartao = null;
        double limite = 0;
        int sair = 1;

        try {
            System.out.print("Digite o limite do cartão:");
            limite = scanner.nextDouble();
            cartao = new CartaoDeCredito(limite);
            System.out.println("Limite do cartão: " + limite);

            while (sair != 0) {
                if (sair != 1) {
                    System.out.println("Opção inválida");
                    System.out.println(USER_INTENTION_REQUEST);
                    sair = scanner.nextInt();
                }

                if (cartao.getSaldo().doubleValue() <= 0) {
                    System.out.println("Saldo esgotado");
                    break;
                }

                scanner.nextLine();
                System.out.println("Digite o nome do produto");
                String nome = scanner.nextLine();
                System.out.println("Digite o valor da compra");
                Double valor = scanner.nextDouble();

                if (valor.isNaN() || nome.isEmpty()) {
                    System.out.println("Valores inválidos");
                    System.out.println(USER_INTENTION_REQUEST);
                    sair = scanner.nextInt();
                }
                boolean compraRealizada = cartao.lancaCompra(new Produto(nome, valor));

                if (compraRealizada) {
                    System.out.println("Compra aprovada");
                    System.out.println(USER_INTENTION_REQUEST);
                    sair = scanner.nextInt();
                } else {
                    System.out.println("Compra negada.");
                    sair = 0;
                }
            }
        } catch (Exception e) {
            System.out.println("Erro de leitura");
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }

        System.out.println("Lista de compras:");
        if (cartao != null) {
            for (Produto produto : cartao.getProdutos()) {
                System.out.println(produto.toString());
            }
        }
    }
}
