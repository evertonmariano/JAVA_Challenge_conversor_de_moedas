import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {

    // Buscando todas as taxas baseadas no Dólar (USD) pela URL da ExchangeRate-API
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/4769622ae269cbed8826cbcb/latest/USD";

    // Cliente HTTP
    public ApiResponse obterTaxasDeCambio() {
        HttpClient client = HttpClient.newHttpClient();

        // Requisição
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .build();

        try { // Resposta
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) { // Verifica se a requisição foi bem-sucedida
                // Converte o JSON para o objeto Java
                return new Gson().fromJson(response.body(), ApiResponse.class);
            } else {
                System.err.println("Erro ao buscar dados: " + response.statusCode());
                return null;
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Erro na conexão com a API: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
