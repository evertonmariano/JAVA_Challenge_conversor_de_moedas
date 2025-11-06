import java.util.Map;

// Esta Classe representa a resposta da API.
public class ApiResponse {
    private String result;
    private String base_code;
    private Map<String, Double> conversion_rates; // Map<String, Double> para pegar todas as moedas dinamicamente.

    // Getters
    public String getResult() {
        return result;
    }

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }

}
