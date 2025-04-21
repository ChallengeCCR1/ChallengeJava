package br.com.fiap.service;

import br.com.fiap.config.ApiConfig;
import br.com.fiap.model.PrevisaoPicoModel;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PrevisaoPicoService {

    private static final String API_BASE = "http://localhost:5000/api";
    private final HttpClient client;

    public PrevisaoPicoService() {
        client = HttpClient.newHttpClient();
    }

    public PrevisaoPicoModel obterPrevisaoPico(String estacao, String horario) {
        try {
            String endpoint = ApiConfig.BASE_URL + "/pico?estacao=" + estacao;
            if (horario != null && !horario.isEmpty()) {
                endpoint += "&horario=" + horario;
            }

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endpoint))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Resposta da API: " + response.body()); // DEBUG

            Gson gson = new Gson();
            return gson.fromJson(response.body(), PrevisaoPicoModel.class);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String gerarGrafico(String estacao) {
        try {
            String endpoint = ApiConfig.BASE_URL + "/pico/grafico?estacao=" + estacao;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endpoint))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Resposta da API (gráfico): " + response.body()); // DEBUG

            Gson gson = new Gson();
            PrevisaoPicoModel pico = gson.fromJson(response.body(), PrevisaoPicoModel.class);
            return pico.getGraficoBase64();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}