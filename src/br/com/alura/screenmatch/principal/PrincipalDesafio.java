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
        int opcao = 1;

        System.out.print("Digite o limite do cartão:");

        try {
            limite = scanner.nextDouble();
            cartao = new CartaoDeCredito(limite);
            System.out.println("Limite do cartão: " + limite);

            while (opcao != 0) {
                if (cartao.getSaldo().doubleValue() <= 0) {
                    System.out.println("Saldo esgotado");
                    break;
                }

                switch (opcao) {
                    case 1:
                        scanner.nextLine();
                        System.out.println("Digite o nome do produto");
                        String nome = scanner.nextLine();
                        System.out.println("Digite o valor da compra");
                        double valor = scanner.nextDouble();
                        if (valor <= 0 || valor > cartao.getSaldo().doubleValue()) {
                            System.out.println("Compra negada");
                            System.out.println(USER_INTENTION_REQUEST);
                            opcao = scanner.nextInt();
                            break;
                        }
                        System.out.println("Compra aprovada");
                        cartao.addProduto(new Produto(nome, valor));
                        System.out.println(USER_INTENTION_REQUEST);
                        opcao = scanner.nextInt();
                        break;
                    case 0:
                        System.out.println("Saindo do programa");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opção inválida");
                        System.out.println(USER_INTENTION_REQUEST);
                        opcao = scanner.nextInt();
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Erro de leitura");
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }

        System.out.println("Lista de compras:");
        for (Produto produto : cartao.getProdutos()) {
            System.out.println(produto.toString());
        }
    }
}
