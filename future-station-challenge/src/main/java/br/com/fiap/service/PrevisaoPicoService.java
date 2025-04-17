package br.com.fiap.service;

import br.com.fiap.model.PrevisaoPicoModel;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PrevisaoPicoService {

    private static final String API_URL = "http://localhost:5000/pico?estacao=NomeDaEstacao";
    private HttpClient client;

    public PrevisaoPicoService(){
        client = HttpClient.newHttpClient();
    }

    public PrevisaoPicoModel obterPrevisaoPico(String estacao, String horario) {
        try {
            String urlStr = "http://localhost:5000/pico?estacao=" + estacao;
            if (horario != null && !horario.isEmpty()) {
                urlStr += "&horario=" + horario;
            }

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlStr))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Aqui você pode processar a resposta JSON (exemplo: usar a biblioteca Gson ou Jackson)
            // Para simulação, vamos criar o modelo PicoModel com a resposta
            PrevisaoPicoModel pico = new PrevisaoPicoModel();
            pico.setEstacao(estacao);
            pico.setHorario(horario);
            pico.setGraficoBase64(response.body());  // Substitua com o conteúdo real do JSON
            return pico;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Similar para a geração do gráfico
    public String gerarGrafico(String estacao) {
        try {
            String urlStr = API_URL + "/api/pico/grafico?estacao=" + estacao;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlStr))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Se a resposta for apenas a base64 da imagem
            if (response.body().startsWith("data:image")) {
                return response.body();  // Retorne diretamente o gráfico em base64
            } else {
                // Caso contrário, tente fazer o parse do JSON
                Gson gson = new Gson();
                PrevisaoPicoModel pico = gson.fromJson(response.body(), PrevisaoPicoModel.class);
                return pico.getGraficoBase64();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
