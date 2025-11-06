import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class ConversorPrincipal {

    // ===== EXTRA Lista para o Histórico EXTRA =====
    private static ArrayList<String> historico = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultaApi consultaApi = new ConsultaApi();

        // 1. Busca as taxas de câmbio UMA VEZ no início. É mais eficiente do que buscar a cada conversão.
        ApiResponse resposta = consultaApi.obterTaxasDeCambio();

        if (resposta == null || !"success".equals(resposta.getResult())) {
            System.out.println("Não foi possível obter as taxas de câmbio. Encerrando.");
            return;
        }

        Map<String, Double> taxas = resposta.getConversion_rates(); // Guarda o mapa de taxas para facilitar o acesso

        // 2. Loop principal do menu
        while (true) {
            exibirMenu();
            try {
                int opcao = scanner.nextInt();

                if (opcao == 0) {
                    System.out.println("\nObrigado por utilizar o meu conversor!");
                    System.out.println("\n======================== PROGRAMA FINALIZADO ========================");
                    break;
                }

                // ===== EXTRA Lógica para Histórico de conversões - Opção 7 EXTRA =====
                if (opcao == 7) {
                    exibirHistorico();
                    continue; // Volta para o início do loop (exibe o menu novamente)
                }

                // Verifica se a opção é uma das conversões válidas (1 a 6)
                if (opcao >= 1 && opcao <= 6) {
                    // Se for válida, AGORA SIM pede o valor
                    System.out.println("Digite o valor que deseja converter: ");
                    double valor = scanner.nextDouble();

                    // 3. Lógica da conversão
                    processarOpcao(opcao, valor, taxas);
                } else {
                    // Se não for 0, nem 7, nem 1-6, é inválida. Exibe a mensagem de erro e o loop continua, voltando ao menu.
                    System.out.println("\nOpção inválida de conversão. Tente novamente!");
                }

            } catch (InputMismatchException e) {
                System.out.println("\nErro: Entrada inválida. Por favor, digite um número.");
                scanner.next(); // Limpa o buffer do scanner
            }
        }
        scanner.close();
    }

    // Metodo para exibir as opções do menu
    private static void exibirMenu() {
        System.out.println("\n*********************************************************************");
        System.out.println("Seja bem-vindo(a) ao Conversor de Moedas do Everton! =)\n");
        System.out.println("1) Dólar =>> Peso argentino");
        System.out.println("2) Peso argentino =>> Dólar");
        System.out.println("3) Dólar =>> Real brasileiro");
        System.out.println("4) Real brasileiro =>> Dólar");
        System.out.println("5) Dólar =>> Peso colombiano");
        System.out.println("6) Peso colombiano =>> Dólar");
        System.out.println("7) Histórico de Conversões");
        System.out.println("0) SAIR");
        System.out.println("\n*********************************************************************");
        System.out.println("Por favor, escolha uma opção válida: ");
    }

    // Metodo para calcular e exibir o resultado
    private static void processarOpcao(int opcao, double valor, Map<String, Double> taxas) {
        // Moedas de interesse
        double taxaARS = taxas.get("ARS"); // Peso Argentino
        double taxaBRL = taxas.get("BRL"); // Real Brasileiro
        double taxaCOP = taxas.get("COP"); // Peso Colombiano

        double resultado = 0;
        String moedaOrigem = "";
        String moedaDestino = "";

        switch (opcao) {
            case 1: // USD >>> ARS
                resultado = valor * taxaARS;
                moedaOrigem = "USD";
                moedaDestino = "ARS";
                break;
            case 2: // ARS >>> USD
                // Lógica inversa: Valor / Taxa
                resultado = valor / taxaARS;
                moedaOrigem = "ARS";
                moedaDestino = "USD";
                break;
            case 3: // USD >>> BRL (Como no exemplo da imagem)
                resultado = valor * taxaBRL;
                moedaOrigem = "USD";
                moedaDestino = "BRL";
                break;
            case 4: // BRL >>> USD
                resultado = valor / taxaBRL;
                moedaOrigem = "BRL";
                moedaDestino = "USD";
                break;
            case 5: // USD >>> COP
                resultado = valor * taxaCOP;
                moedaOrigem = "USD";
                moedaDestino = "COP";
                break;
            case 6: // COP >>> USD
                resultado = valor / taxaCOP;
                moedaOrigem = "COP";
                moedaDestino = "USD";
                break;
        }

        // Exibe o resultado formatado
        System.out.printf("\nValor %.1f [%s] corresponde ao valor final de =>>> %.10f [%s]\n",
                valor, moedaOrigem, resultado, moedaDestino);

        // ===== EXTRA Adicionando ao Histórico e Log EXTRA =====
        // 1. Criar a string de registro
        String registro = String.format("Conversão: %.2f %s para %s. Resultado: %.2f %s",
                valor, moedaOrigem, moedaDestino, resultado, moedaDestino);

        // 2. Adicionar ao histórico (ArrayList)
        historico.add(registro);

        // 3. Registrar no arquivo de log (conversoes.log)
        registrarLog(registro);
    }

    // ===== EXTRA Metodo para exibir o Histórico EXTRA =====
    private static void exibirHistorico() {
        System.out.println("\n====================== HISTÓRICO DE CONVERSÕES ======================");
        if (historico.isEmpty()) {
            System.out.println("Nenhuma conversão foi realizada ainda.");
        } else {
            // Itera sobre a lista e imprime cada registro
            for (String registro : historico) {
                System.out.println("- " + registro);
            }
        }
        System.out.println("=====================================================================");
    }

    // ===== EXTRA Metodo para registrar o Log em arquivo EXTRA =====
    private static void registrarLog(String log) {
        // Define o formato da data e hora
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String timestamp = dtf.format(LocalDateTime.now());

        // Usa try-with-resources para garantir que o arquivo seja fechado
        // O 'true' no FileWriter indica que queremos adicionar (append) ao final do arquivo
        try (PrintWriter out = new PrintWriter(new FileWriter("conversoes.log", true))) {
            out.println(timestamp + " - " + log);
        } catch (IOException e) {
            // Imprime um erro no console se não conseguir escrever o log
            System.err.println("Erro ao escrever no arquivo de log: " + e.getMessage());
        }
    }

}
