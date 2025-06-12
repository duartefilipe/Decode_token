# Decode Token

Um microserviço simples construído com Spring Boot e Kotlin para decodificar tokens JWT e extrair suas informações (claims) de forma rápida.

## 🎯 Objetivo

Este projeto foi criado como uma ferramenta de apoio ao desenvolvimento para resolver um problema comum: a necessidade de inspecionar o conteúdo de um `access_token` (JWT) sem precisar passar por todo o fluxo de login de uma aplicação principal.

Ele agiliza testes e a depuração de outros serviços que dependem de informações contidas no token, como `accountId` e outras claims customizadas.

## ✨ Funcionalidades

- Endpoint único que recebe um Bearer Token via cabeçalho `Authorization`.
- Decodifica o payload do JWT sem precisar da chave secreta de assinatura, tornando-o ideal para ambientes de teste.
- Retorna todas as claims (informações) do token em um formato JSON de fácil leitura.

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** [Kotlin](https://kotlinlang.org/)
- **Framework:** [Spring Boot 3](https://spring.io/projects/spring-boot)
- **Build Tool:** [Gradle](https://gradle.org/)
- **Biblioteca JWT:** [Java JWT (jjwt)](https://github.com/jwtk/jjwt)
- **Biblioteca JSON:** [Gson](https://github.com/google/gson)

## 🚀 Como Executar o Projeto

Siga os passos abaixo para rodar a aplicação localmente.

### Pré-requisitos

- [Java (JDK) 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) ou superior.
- [Git](https://git-scm.com/) instalado.

### Passos para Execução

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/Decode_token.git](https://github.com/seu-usuario/Decode_token.git)
    ```
    *(Substitua `seu-usuario` pelo seu nome de usuário no GitHub)*

2.  **Navegue até a pasta do projeto:**
    ```bash
    cd Decode_token
    ```

3.  **Execute a aplicação usando o Gradle Wrapper:**

    - No Linux ou macOS:
        ```bash
        ./gradlew bootRun
        ```
    - No Windows:
        ```bash
        gradlew.bat bootRun
        ```

O servidor irá iniciar, por padrão, na porta `8080`.

## ⚙️ Configuração (Opcional)

Se a porta `8080` já estiver em uso por outra aplicação, você pode alterá-la facilmente.

1.  Abra o arquivo: `src/main/resources/application.properties`
2.  Adicione a seguinte linha para usar a porta `8081`, por exemplo:
    ```properties
    server.port=8081
    ```

## Endpoints da API

### Decodificar Token

Retorna todas as claims encontradas no payload do JWT fornecido.

- **Método:** `GET`
- **Endpoint:** `/api/decode`
- **Headers:**
    - `Authorization`: `Bearer <seu_token_jwt>`

#### Exemplo de Requisição (usando `curl`)

Substitua `SEU_TOKEN_AQUI` pelo seu token de acesso completo.

```bash
curl -X GET http://localhost:8080/api/decode \
-H "Authorization: Bearer SEU_TOKEN_AQUI"
