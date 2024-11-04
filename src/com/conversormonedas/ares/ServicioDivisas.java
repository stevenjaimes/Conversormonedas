package com.conversormonedas.ares;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpConnectTimeoutException;
import java.net.http.HttpTimeoutException;
import java.io.IOException;
import java.util.Map;

public class ServicioDivisas {
    private static final String API_KEY = "04665447806d3d934a470a4e";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";

    // Método para obtener las tasas de cambio con una moneda base específica
    public Map<String, Double> obtenerTasasDeCambio() {
        try {
            // Crear cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Construir solicitud HTTP GET
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL))
                    .GET()
                    .build();

            // Enviar solicitud y obtener respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Comprobar el código de respuesta HTTP
            if (response.statusCode() != 200) {
                System.out.println("Error: No se pudo obtener la respuesta de la API. Código de estado: " + response.statusCode());
                return null;
            }

            // Parsear respuesta JSON
            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");

            // Convertir el objeto JSON a un mapa
            return new Gson().fromJson(rates, Map.class);

        } catch (HttpConnectTimeoutException e) {
            System.out.println("Error: Tiempo de conexión agotado al intentar conectar con la API.");
        } catch (HttpTimeoutException e) {
            System.out.println("Error: Tiempo de espera agotado al recibir la respuesta de la API.");
        } catch (IOException e) {
            System.out.println("Error: Problema de entrada/salida al intentar obtener las tasas de cambio.");
        } catch (InterruptedException e) {
            System.out.println("Error: La solicitud fue interrumpida.");
            Thread.currentThread().interrupt(); // Restablecer el estado de interrupción
        } catch (IllegalArgumentException e) {
            System.out.println("Error: La URI proporcionada es inválida.");
        } catch (com.google.gson.JsonSyntaxException e) {
            System.out.println("Error: La respuesta de la API no está en un formato JSON válido.");
        } catch (Exception e) {
            System.out.println("Error inesperado al obtener las tasas de cambio: " + e.getMessage());
        }

        return null;
    }
}
