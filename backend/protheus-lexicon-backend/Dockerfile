# Etapa 1: build com Maven
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

# Copia apenas pom.xml primeiro para aproveitar cache do Docker
COPY pom.xml .

# Baixa dependências (vai ficar em cache se pom.xml não mudar)
RUN mvn dependency:go-offline -B

# Copia o código fonte
COPY src ./src

# Executa o build
RUN mvn clean package -DskipTests

# Etapa 2: Runtime
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copia o JAR da primeira etapa
COPY --from=builder /app/target/protheus-lexicon-backend.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]