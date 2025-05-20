package br.com.alura.screenmatch.principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import br.com.alura.screenmatch.modelos.Produto;

public class PrincipalDesafio {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();
        int limite = 0;
        int opcao = 1;

        System.out.print("Digite o limite do cartão:");

        try {
            limite = scanner.nextInt();
            System.out.println("Limite do cartão: " + limite);

            while (opcao != 0) {
                switch (opcao) {
                    case 1:
                        scanner.nextLine();
                        System.out.println("Digite o nome do produto");
                        String nome = scanner.nextLine();
                        System.out.println("Digite o valor da compra");
                        double valor = scanner.nextDouble();
                        if (valor <= 0 || valor > limite) {
                            System.out.println("Compra negada");
                            break;
                        }
                        System.out.println("Compra aprovada");
                        Produto produto = new Produto(nome, valor);
                        produtos.add(produto);
                        System.out.println("Digite 0 para sair ou 1 para continuar");
                        opcao = scanner.nextInt();
                        break;
                    case 0:
                        System.out.println("Saindo do programa");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opção inválida");
                        System.out.println("Digite 0 para sair ou 1 para continuar");
                        opcao = scanner.nextInt();
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Erro de leitura");
        } finally {
            scanner.close();
        }

        Collections.sort(produtos);

        System.out.println("Lista de compras:");
        for (Produto produto : produtos) {
            System.out.println(produto.getNome() + " - " + produto.getPreco().doubleValue());
        }
    }
}
