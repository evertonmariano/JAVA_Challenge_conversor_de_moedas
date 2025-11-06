<h1 align="center"> JAVA - Challenge Conversor de Moedas </h1>

# ☕ Conversor de Moedas

![Java](https://img.shields.io/badge/Java-17%2B-blue?style=for-the-badge&logo=java)

Um conversor de moedas interativo de console desenvolvido em Java. Este projeto foi criado como um desafio prático para consolidar o aprendizado em desenvolvimento back-end, focando no consumo de APIs, manipulação de JSON e interação com o usuário.

## 📖 Índice

* [Descrição](#-descrição)
* [Funcionalidades](#-funcionalidades)
* [Tecnologias Utilizadas](#-tecnologias-utilizadas)
* [Pré-requisitos](#-pré-requisitos)
* [Como Executar](#-como-executar)
* [Exemplo de Uso](#-exemplo-de-uso)
* [Estrutura do Projeto](#-estrutura-do-projeto)
* [API](#-api)
* [Autor](#-autor)

## 📙 Descrição

Este programa permite ao usuário converter valores entre diferentes moedas com base nas taxas de câmbio mais recentes. O usuário interage com um menu simples no console, escolhe a conversão desejada e insere um valor. O programa então se conecta a uma API de câmbio em tempo real, realiza o cálculo e exibe o resultado.

## ✨ Funcionalidades

* **Menu Interativo:** Navegação simples e intuitiva via console.
* **Cotações em Tempo Real:** Utiliza a API `ExchangeRate-API` para buscar as taxas de câmbio mais atuais.
* **Conversões Principais:**
   * Dólar (USD) ⇄ Peso Argentino (ARS)
   * Dólar (USD) ⇄ Real Brasileiro (BRL)
   * Dólar (USD) ⇄ Peso Colombiano (COP)
* **Histórico de Conversões:** Salva um histórico de todas as conversões realizadas durante a sessão (opção 8 do menu).
* **Logs Persistentes:** Registra cada conversão com data e hora em arquivos de log (`conversoes.log` e `conversoes_extras.log`) na raiz do projeto.

## 🛠️ Tecnologias Utilizadas

* **Java 17+:** Linguagem principal do projeto.
* **Java HTTP Client:** Biblioteca nativa do Java (desde o Java 11) para realizar requisições HTTP.
* **Gson (v2.11.0):** Biblioteca do Google para "parsear" (converter) a resposta JSON da API em objetos Java.

## 🔑 Pré-requisitos

Antes de começar, você precisará ter o seguinte instalado em sua máquina:
* [JDK (Java Development Kit)](https://www.oracle.com/java/technologies/javase-downloads.html) - Versão 17 ou superior.
* Uma chave de API gratuita da [ExchangeRate-API](https://www.exchangerate-api.com/).
* O arquivo `.jar` da biblioteca **Gson v2.11.0**. Você pode baixá-lo [aqui](https://search.maven.org/artifact/com.google.code.gson/gson/2.11.0/jar).

## 🚀 Como Executar

Este projeto não utiliza um gerenciador de dependências (como Maven). A configuração da biblioteca Gson deve ser feita manualmente.

### 1. Configuração

1.  **Clone o repositório:**
    ```bash
    git clone https://[URL-DO-SEU-REPOSITORIO]/ConverdorDeMoedas.git
    cd ConverdorDeMoedas
    ```

2.  **Atualize a Chave da API:**
    Abra o arquivo `src/ConsultaApi.java` e substitua a URL pela URL com a sua chave de API pessoal:
    ```java
    // em src/ConsultaApi.java
    private static final String API_URL = "[https://v6.exchangerate-api.com/v6/SUA_CHAVE_AQUI/latest/USD](https://v6.exchangerate-api.com/v6/SUA_CHAVE_AQUI/latest/USD)";
    ```

3.  **Adicione a Biblioteca Gson:**
    Conforme a estrutura do projeto, a IDE espera encontrar o arquivo `.jar` na pasta `gson/`.
   * Se você estiver configurando o projeto do zero em uma IDE (como IntelliJ), copie o `gson-2.11.0.jar` para a pasta `gson/` e, na IDE, clique com o botão direito no arquivo `.jar` e selecione **"Add as Library..."**.

### 2. Execução (via IDE)

1.  Após adicionar o Gson como biblioteca, sua IDE não deve mostrar mais erros de compilação.
2.  Encontre a classe `src/ConversorPrincipal.java`.
3.  Clique com o botão direito e selecione **"Run 'ConversorPrincipal.main()'"**.

### 3. Execução (via Terminal)

Se preferir executar pelo terminal (estando na pasta raiz `ConverdorDeMoedas`):

1.  **Compilar:**
    ```bash
    # (Windows - use ponto e vírgula ";")
    javac -cp ".;gson/gson-2.11.0.jar" src/*.java
    ```

2.  **Executar:**
    ```bash
    # (Windows - use ponto e vírgula ";")
    java -cp ".;gson/gson-2.11.0.jar;src" ConversorPrincipal
    ```

## 🖥️ Exemplo de Uso

Ao iniciar o programa, o usuário é recebido com o menu principal:
Entendido. Acho que pode ter havido uma pequena confusão na minha explicação anterior, peço desculpas.

O arquivo README.md é um arquivo de texto puro, e o conteúdo que eu escrevi já é o código em formato Markdown.

Você não precisa converter nada. O que você precisa fazer é copiar o texto abaixo e colar em um arquivo chamado README.md.

Quando você (ou o GitHub) abrir esse arquivo, ele será "renderizado" e ficará bonito. O texto que você deve copiar é este:

(Copie tudo que está dentro da caixa de código abaixo)

Markdown

# ☕ Conversor de Moedas

![Java](https://img.shields.io/badge/Java-17%2B-blue?style=for-the-badge&logo=java)

Um conversor de moedas interativo de console desenvolvido em Java. Este projeto foi criado como um desafio prático para consolidar o aprendizado em desenvolvimento back-end, focando no consumo de APIs, manipulação de JSON e interação com o usuário.

## 📖 Índice

* [Descrição](#-descrição)
* [Funcionalidades](#-funcionalidades)
* [Tecnologias Utilizadas](#-tecnologias-utilizadas)
* [Pré-requisitos](#-pré-requisitos)
* [Como Executar](#-como-executar)
* [Exemplo de Uso](#-exemplo-de-uso)
* [Estrutura do Projeto](#-estrutura-do-projeto)
* [API](#-api)
* [Autor](#-autor)

## 📙 Descrição

Este programa permite ao usuário converter valores entre diferentes moedas com base nas taxas de câmbio mais recentes. O usuário interage com um menu simples no console, escolhe a conversão desejada e insere um valor. O programa então se conecta a uma API de câmbio em tempo real, realiza o cálculo e exibe o resultado.

## ✨ Funcionalidades

* **Menu Interativo:** Navegação simples e intuitiva via console.
* **Cotações em Tempo Real:** Utiliza a API `ExchangeRate-API` para buscar as taxas de câmbio mais atuais.
* **Conversões Principais:**
   * Dólar (USD) ⇄ Peso Argentino (ARS)
   * Dólar (USD) ⇄ Real Brasileiro (BRL)
   * Dólar (USD) ⇄ Peso Colombiano (COP)
* **Histórico de Conversões:** Salva um histórico de todas as conversões realizadas durante a sessão (opção 8 do menu).
* **Logs Persistentes:** Registra cada conversão com data e hora em arquivos de log (`conversoes.log` e `conversoes_extras.log`) na raiz do projeto.

## 🛠️ Tecnologias Utilizadas

* **Java 17+:** Linguagem principal do projeto.
* **Java HTTP Client:** Biblioteca nativa do Java (desde o Java 11) para realizar requisições HTTP.
* **Gson (v2.11.0):** Biblioteca do Google para "parsear" (converter) a resposta JSON da API em objetos Java.

## 🔑 Pré-requisitos

Antes de começar, você precisará ter o seguinte instalado em sua máquina:
* [JDK (Java Development Kit)](https://www.oracle.com/java/technologies/javase-downloads.html) - Versão 17 ou superior.
* Uma chave de API gratuita da [ExchangeRate-API](https://www.exchangerate-api.com/).
* O arquivo `.jar` da biblioteca **Gson v2.11.0**. Você pode baixá-lo [aqui](https://search.maven.org/artifact/com.google.code.gson/gson/2.11.0/jar).

## 🚀 Como Executar

Este projeto não utiliza um gerenciador de dependências (como Maven). A configuração da biblioteca Gson deve ser feita manualmente.

### 1. Configuração

1.  **Clone o repositório:**
    ```bash
    git clone https://[URL-DO-SEU-REPOSITORIO]/ConverdorDeMoedas.git
    cd ConverdorDeMoedas
    ```

2.  **Atualize a Chave da API:**
    Abra o arquivo `src/ConsultaApi.java` e substitua a URL pela URL com a sua chave de API pessoal:
    ```java
    // em src/ConsultaApi.java
    private static final String API_URL = "[https://v6.exchangerate-api.com/v6/SUA_CHAVE_AQUI/latest/USD](https://v6.exchangerate-api.com/v6/SUA_CHAVE_AQUI/latest/USD)";
    ```

3.  **Adicione a Biblioteca Gson:**
    Conforme a estrutura do projeto, a IDE espera encontrar o arquivo `.jar` na pasta `gson/`.
   * Se você estiver configurando o projeto do zero em uma IDE (como IntelliJ), copie o `gson-2.11.0.jar` para a pasta `gson/` e, na IDE, clique com o botão direito no arquivo `.jar` e selecione **"Add as Library..."**.

### 2. Execução (via IDE)

1.  Após adicionar o Gson como biblioteca, sua IDE não deve mostrar mais erros de compilação.
2.  Encontre a classe `src/ConversorPrincipal.java`.
3.  Clique com o botão direito e selecione **"Run 'ConversorPrincipal.main()'"**.

### 3. Execução (via Terminal)

Se preferir executar pelo terminal (estando na pasta raiz `ConverdorDeMoedas`):

1.  **Compilar:**
    ```bash
    # (Windows - use ponto e vírgula ";")
    javac -cp ".;gson/gson-2.11.0.jar" src/*.java
    ```

2.  **Executar:**
    ```bash
    # (Windows - use ponto e vírgula ";")
    java -cp ".;gson/gson-2.11.0.jar;src" ConversorPrincipal
    ```

## 🖥️ Exemplo de Uso

**ClassePrincipal:**



*********************************************************************
Seja bem-vindo(a) ao Conversor de Moedas do Everton! =)

1) Dólar =>> Peso argentino
2) Peso argentino =>> Dólar
3) Dólar =>> Real brasileiro
4) Real brasileiro =>> Dólar
5) Dólar =>> Peso colombiano
6) Peso colombiano =>> Dólar
7) Histórico de Conversões
0) SAIR

*********************************************************************
Por favor, escolha uma opção válida:

--- 

**ClasseExtra:**



*********************************************************************
Seja bem-vindo(a) ao Conversor de Moedas do Everton! =)

1) Realizar uma conversão
2) Ver histórico de conversões
0) SAIR

*********************************************************************
Por favor, escolha uma opção válida:

--- 

## 📂 Estrutura do Projeto

```
ConverdorDeMoedas/ 
├── .gitignore 
├── gson/ 
│ └── gson-2.11.0.jar            # Biblioteca Gson (dependência) 
├── src/ 
│ ├── ApiResponse.java           # (POJO) Classe que mapeia a resposta JSON 
│ ├── ConsultaApi.java           # Classe responsável pela requisição HTTP 
│ ├── ConversorExtra.java        # Classe com lógicas/funções extras 
│ └── ConversorPrincipal.java    # Classe principal (main) com o menu 
├── conversoes.log               # Log principal das conversões 
├── conversoes_extras.log        # Log de conversões extras 
└── README.md # Este arquivo
```

## 🌐 API

Este projeto utiliza a **[ExchangeRate-API](https://www.exchangerate-api.com/docs/java-api)** para obter as cotações de câmbio em tempo real.

## 👨‍💻 Autor

Feito por **Everton Mariano Nunes** como parte de um desafio de programação.