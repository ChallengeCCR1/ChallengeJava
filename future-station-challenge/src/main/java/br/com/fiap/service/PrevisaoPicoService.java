package br.com.fiap.service;

import br.com.fiap.model.PrevisaoPicoModel;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PrevisaoPicoService {

    private static final String API_BASE = "http://localhost:5000/api";
    private HttpClient client;

    public PrevisaoPicoService(){
        client = HttpClient.newHttpClient();
    }

    public PrevisaoPicoModel obterPrevisaoPico(String estacao, String horario) {
        try {
            String urlStr = "http://localhost:5000/api/pico?estacao=" + estacao;
            if (horario != null && !horario.isEmpty()) {
                urlStr += "&horario=" + horario;
            }

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlStr))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Resposta da API: " + response.body()); // DEBUG

            Gson gson = new Gson();
            PrevisaoPicoModel pico = gson.fromJson(response.body(), PrevisaoPicoModel.class);
            return pico;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Similar para a geração do gráfico
    public String gerarGrafico(String estacao) {
        try {
            String urlStr = "http://localhost:5000/api/pico/grafico?estacao=" + estacao;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlStr))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Resposta da API (gráfico): " + response.body());  // debug

            Gson gson = new Gson();
            PrevisaoPicoModel pico = gson.fromJson(response.body(), PrevisaoPicoModel.class);
            return pico.getGraficoBase64();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
