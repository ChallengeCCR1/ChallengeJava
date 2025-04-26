package br.com.fiap.service;

import br.com.fiap.config.ApiConfig;
import br.com.fiap.dto.MapaLinhaDTO;
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MapaLinhaService {
    private static final HttpClient client = HttpClient.newHttpClient();

    public MapaLinhaDTO mostrarMapaLinha9() {
        String endpoint = ApiConfig.BASE_URL_PYTHON + "api/mapa/linha9";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String json = response.body();
                Gson gson = new Gson();
                return gson.fromJson(json, MapaLinhaDTO.class);
            } else {
                System.out.println("❌ Erro ao buscar mapa (status): " + response.statusCode());
                return null;
            }

        } catch (Exception e) {
            System.out.println("❌ Erro na requisição:");
            e.printStackTrace();
            return null;
        }
    }
}
