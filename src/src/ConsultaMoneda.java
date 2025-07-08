package src;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    public Moneda buscaMoneda(String monedaOrigen){
        //  Construir el HTTPrequest
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/471bcafe6293efc43d0ade55/latest/"+monedaOrigen);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Moneda moneda = new Gson().fromJson(response.body(), Moneda.class);
            return moneda;
        } catch (Exception e) {
            throw new RuntimeException("No encontre esa moneda"+ e.getMessage());
        }
    }
}
