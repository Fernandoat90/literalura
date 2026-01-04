package com.AluraChallengeLiteratura.LiterAlura.service;

import org.springframework.stereotype.Service;
import java.net.URI;
import java.net.http.*;

@Service
public class LiterAluraService {


    private final HttpClient client= HttpClient.newHttpClient();

    public String BuscarLibroPorTitulo(String Titulo){
        String url = "https://gutendex.com/books/?search=" + Titulo.replace(" ", "%20");

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();

        } catch (Exception e) {
            throw new RuntimeException("Error al consultar la API: " + e.getMessage());
        }
    }

    public String BuscarLibroPorID(int id) {
        String url = "https://gutendex.com/books/?ids=" + id;

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();

        } catch (Exception e) {
            throw new RuntimeException("Error al consultar la API: " + e.getMessage());
        }
    }

}
