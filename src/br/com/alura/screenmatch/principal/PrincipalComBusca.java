package br.com.alura.screenmatch.principal;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import io.github.cdimascio.dotenv.Dotenv;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("API_KEY");
        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite um filme para busca:");
        var busca = leitura.nextLine();
        leitura.close();
        String endereco = "https://www.omdbapi.com/?t="
                + URLEncoder.encode(busca, Charset.forName("UTF-8")) + "&apikey=" + apiKey;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
            HttpResponse<String> response =
                    client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);

            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();
            TituloOmdb queriedTitulo = gson.fromJson(json, TituloOmdb.class);
            System.out.println(queriedTitulo);

            Titulo meuTitulo = new Titulo(queriedTitulo);
            System.out.println("Titulo já convertido");
            System.out.println(meuTitulo);
        } catch (NumberFormatException e) {
            System.out.println("Aconteceu um erro: ");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Algum erro de argumento na busca, verifique o endereço.");
        }

        System.out.println("O programa finalizou corretamente!");
    }
}
