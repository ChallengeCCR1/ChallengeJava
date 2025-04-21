package br.com.fiap.service;

import br.com.fiap.config.ApiConfig;
import br.com.fiap.model.MapaLinhaModel;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MapaLinhaService {

    public static void mostrarMapaLinha9() {

        String endpoint = ApiConfig.BASE_URL + "/api/linha9";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String json = response.body();
                Gson gson = new Gson();
                MapaLinhaModel linha = gson.fromJson(json, MapaLinhaModel.class);

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
