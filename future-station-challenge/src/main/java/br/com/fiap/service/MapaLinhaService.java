package br.com.fiap.service;

import br.com.fiap.model.MapaLinha;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MapaLinhaService {

    public static void mostrarMapaLinha9() {

        String url = "http://localhost:5000/mapa/linha9";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String json = response.body();
                Gson gson = new Gson();
                MapaLinha linha = gson.fromJson(json, MapaLinha.class);

                System.out.println("✅ Mapa recebido:");
                System.out.println(linha);
            } else {
                System.out.println("❌ Erro ao buscar mapa: " + response.statusCode());
            }
        } catch (Exception e) {
            System.out.println("❌ Erro na requisição: " + e.getMessage());
        }
    }
}

