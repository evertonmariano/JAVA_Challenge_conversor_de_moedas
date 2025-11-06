import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime; // Para o EXTRA do Log
import java.time.format.DateTimeFormatter; // Para o EXTRA do Log
import java.util.ArrayList; // Para o EXTRA do Histórico
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class ConversorExtra {

    // ===== EXTRA Lista para o Histórico EXTRA =====
    private static ArrayList<String> historico = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultaApi consultaApi = new ConsultaApi();

        // 1. Busca as taxas de câmbio UMA VEZ
        ApiResponse resposta = consultaApi.obterTaxasDeCambio();

        if (resposta == null || !"success".equals(resposta.getResult())) {
            System.out.println("Não foi possível obter as taxas de câmbio. Encerrando.");
            return;
        }

        Map<String, Double> taxas = resposta.getConversion_rates(); // Guarda o mapa de taxas

        // 2. Loop principal do menu
        while (true) {
            exibirMenu(); // Exibe o novo menu simplificado
            try {
                int opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        // Nova função para conversão genérica
                        iniciarConversao(scanner, taxas);
                        break;
                    case 2:
                        // Antiga opção 7 (Histórico)
                        exibirHistorico();
                        break;
                    case 0:
                        // Sair
                        System.out.println("\nObrigado por utilizar o meu conversor!");
                        System.out.println("\n======================== PROGRAMA FINALIZADO ========================");
                        scanner.close(); // Fechar o scanner aqui
                        return; // Encerra o metodo main e, portanto, o programa
                    default:
                        // Opção inválida
                        System.out.println("\nOpção inválida. Tente novamente!");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("\nErro: Entrada inválida. Por favor, digite um número.");
                scanner.next(); // Limpa o buffer do scanner
            }
        }
        // O scanner.close() foi movido para dentro do 'case 0' para evitar fechar System.in
    }

    // Metodo para exibir as opções do menu (MODIFICADO)
    private static void exibirMenu() {
        System.out.println("\n*********************************************************************");
        System.out.println("Seja bem-vindo(a) ao Conversor de Moedas do Everton! =)\n");
        System.out.println("1) Realizar uma conversão");
        System.out.println("2) Ver histórico de conversões");
        System.out.println("0) SAIR");
        System.out.println("\n*********************************************************************");
        System.out.println("Por favor, escolha uma opção válida: ");
    }

    /*** NOVO METODO para lidar com conversão genérica >> Substitui o antigo processarOpcao() ***/

    private static void iniciarConversao(Scanner scanner, Map<String, Double> taxas) {
        try {
            // 1. Pedir Moeda de Origem
            System.out.println("\nDigite o código da moeda de ORIGEM (ex: USD(Dólar americano), BRL(Real brasileiro), ARS(Peso argentino)):");
            String moedaOrigem = scanner.next().toUpperCase();

            // 2. Pedir Moeda de Destino
            System.out.println("Digite o código da moeda de DESTINO (ex: EUR(Euro), JPY(Iene japonês), COP(Peso colombiano)):");
            String moedaDestino = scanner.next().toUpperCase();

            // 3. Validação
            if (!taxas.containsKey(moedaOrigem) || !taxas.containsKey(moedaDestino)) {
                System.out.println("Erro: Uma ou ambas as moedas não foram encontradas nas taxas.");
                System.out.println("Por favor, use códigos de 3 letras da Moeda (ex: USD, BRL, EUR).");
                return; // Volta ao menu principal
            }

            // 4. Pedir Valor
            System.out.println("Digite o valor que deseja converter:");
            double valor = scanner.nextDouble();

            // 5. Calcular a conversão usando a fórmula universal
            double taxaOrigem = taxas.get(moedaOrigem);
            double taxaDestino = taxas.get(moedaDestino);

            // Fórmula: (Valor / TaxaOrigem) * TaxaDestino
            // Ex: (100 BRL / 5.2 BRL_por_USD) * 900 ARS_por_USD
            double resultado = (valor / taxaOrigem) * taxaDestino;

            // 6. Exibir resultado
            System.out.printf("\nValor %.2f [%s] corresponde ao valor final de =>>> %.10f [%s]\n",
                    valor, moedaOrigem, resultado, moedaDestino);

            // 7. Registrar no Histórico e Log (Sua lógica existente)
            String registro = String.format("Conversão: %.2f %s para %s. Resultado: %.10f %s",
                    valor, moedaOrigem, moedaDestino, resultado, moedaDestino);

            historico.add(registro);
            registrarLog(registro);

        } catch (InputMismatchException e) {
            System.out.println("\nErro: Valor inválido. Por favor, digite um número (use vírgula ou ponto decimal conforme sua localidade).");
            scanner.next(); // Limpa o buffer
        }
    }

    /*** O metodo processarOpcao(int opcao, double valor, Map<String, Double> taxas)
     * >>> foi REMOVIDO, pois foi substituído por iniciarConversao().***/

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

