package br.com.fiap.service;

import br.com.fiap.config.ApiConfig;
import br.com.fiap.model.StatusLinhaModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class StatusLinhaService {

    public static void mostrarStatusPorLinha(String nomeLinhaDesejada) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(ApiConfig.BASE_URL + "/status_linhas_ccr"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Código da resposta HTTP: " + response.statusCode());
            System.out.println("Corpo da resposta: " + response.body());

            if (response.statusCode() != 200) {
                throw new Exception("Erro ao acessar API: Código " + response.statusCode());
            }

            String json = response.body();

            Gson gson = new Gson();
            Type listType = new TypeToken<List<StatusLinhaModel>>() {}.getType();
            List<StatusLinhaModel> linhas = gson.fromJson(json, listType);

            for (StatusLinhaModel linha : linhas) {
                System.out.println("Linha recebida: " + linha.getNome());
                if (linha.getNome().toLowerCase().contains(nomeLinhaDesejada.toLowerCase())) {
                    JOptionPane.showMessageDialog(null,
                            linha.getNome() + ":\n" + linha.getStatus(),
                            "Status da Linha", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }

            JOptionPane.showMessageDialog(null, "Linha não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace(); // importante para debug
            JOptionPane.showMessageDialog(null,
                    "Erro ao buscar status da linha: " + e.toString(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}