package br.com.alura.screenmatch.principal;

import java.util.ArrayList;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão", 1970);
        meuFilme.avalia(9);
        Filme outroFilme = new Filme("Avatar", 2023);
        outroFilme.avalia(6);
        var filmeDoPaulo = new Filme("Dogville", 2003);
        filmeDoPaulo.avalia(10);
        Serie lost = new Serie("Lost", 2000);

        ArrayList<Titulo> listaDeAssistidos = new ArrayList<>();
        listaDeAssistidos.add(filmeDoPaulo);
        listaDeAssistidos.add(meuFilme);
        listaDeAssistidos.add(outroFilme);
        listaDeAssistidos.add(lost);

        for (Titulo itemAssistido : listaDeAssistidos) {
            System.out.println(itemAssistido.getNome());
            if (itemAssistido instanceof Filme filme && filme.getClassificacao() > 2) {
                // Pattern Matching for instanceof é uma feature que fez parte do
                // projeto Amber, do OpenJDK. Este projeto continua a introduzir uma
                // série de recursos voltados à produtividade, como por exemplo:
                // listaDeAssistidos.forEach(System.out::println); NOSONAR
                System.out.println("Classificação: %s".formatted(filme.getClassificacao()));
            }
        }
    }
}
