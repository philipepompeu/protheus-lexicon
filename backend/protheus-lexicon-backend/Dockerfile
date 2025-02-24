# Usa a imagem do OpenJDK 17 como base
FROM openjdk:17-jdk-slim

# Define o diretуrio de trabalho dentro do container
WORKDIR /app

# Copia o arquivo JAR gerado pelo Maven
COPY /target/protheus-lexicon-backend.jar app.jar

# Expхe a porta da aplicaзгo
EXPOSE 8080

# Comando para rodar a aplicaзгo
ENTRYPOINT ["java", "-jar", "app.jar"]
