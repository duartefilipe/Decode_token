# Etapa de build usando Maven
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

# Copia o conteúdo do projeto
COPY . .

# Compila o projeto e gera o .jar
RUN mvn clean package -DskipTests

# Etapa de execução com JDK leve
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copia apenas o jar gerado na etapa anterior
COPY --from=builder /app/target/decode-token-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Comando de entrada
ENTRYPOINT ["java", "-jar", "app.jar"]
