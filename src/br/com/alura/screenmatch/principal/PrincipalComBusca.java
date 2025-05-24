package br.com.alura.screenmatch.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import com.google.gson.Gson;
import br.com.alura.screenmatch.modelos.Titulo;
import io.github.cdimascio.dotenv.Dotenv;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("API_KEY");
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um filme para busca:");
        var busca = leitura.nextLine();

        String endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=" + apiKey;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client
                .send(httpRequest, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);
        leitura.close();

        Gson gson = new Gson();
        Titulo queriedTitulo = gson.fromJson(json, Titulo.class);
        System.out.println(queriedTitulo);
    }
}
