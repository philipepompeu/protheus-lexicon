# Protheus Lexicon

Este projeto tem como objetivo fornecer uma aplicação web para consulta e comparação de dicionários do Protheus.

## 📌 Pré-requisitos

- **Docker** (recomendado) ou **Podman**
- **Docker Compose** ou **Podman Compose**
- **Node.js** (se quiser rodar o frontend localmente)
- **Java 17** e **Maven** (se quiser rodar o backend localmente)

## 🚀 Como Rodar a Aplicação

A maneira mais fácil de rodar a aplicação é usando **Docker** ou **Podman**.

### **1️⃣ Rodando com Docker**

1. **Subir todos os serviços (banco, backend, frontend e nginx)**
   ```sh
   docker-compose up -d --build
   ```
2. **Acessar a aplicação no navegador:**
   - Frontend: [`http://localhost`](http://localhost)
   - Backend (API): [`http://localhost/api`](http://localhost/api)

### **2️⃣ Rodando com Podman**

Caso esteja utilizando **Podman**, use `podman-compose`:

1. **Subir os serviços:**
   ```sh
   podman-compose up -d --build
   ```
2. **Acessar a aplicação no navegador:**
   - Frontend: [`http://localhost`](http://localhost)
   - Backend (API): [`http://localhost/api`](http://localhost/api)

### **3️⃣ Parar os Containers**
Para interromper os serviços rodando no Docker ou Podman:
```sh
docker-compose down  # ou podman-compose down
```

---

## 🔧 Rodando Manualmente (Alternativa)
Caso não queira usar Docker/Podman, siga os passos abaixo.

### **Frontend**

#### ✅ Requisitos Mínimos
- Node.js (versão 16 ou superior)
- NPM (versão 8 ou superior) ou Yarn
- Vue CLI

#### ▶ Passo-a-Passo
1. **Instalar dependências:**
   ```sh
   cd frontend
   npm install
   ```
2. **Executar localmente:**
   ```sh
   npm run serve
   ```
   - O frontend será acessível em `http://localhost:8082/`

3. **Gerar build para produção:**
   ```sh
   npm run build
   ```

### **Backend**

#### ✅ Requisitos Mínimos
- Java 17 ou superior
- Maven
- PostgreSQL (com um banco de dados criado)

#### ▶ Passo-a-Passo
1. **Configurar o banco de dados:**
   - Criar um banco no PostgreSQL
   - Atualizar as credenciais no `application.properties`

2. **Compilar e executar o backend:**
   ```sh
   cd backend/protheus-lexicon-backend
   mvn clean package
   java -jar target/protheus-lexicon-backend.jar
   ```
   - O backend será acessível em `http://localhost:8080/`

3. **Executar em modo desenvolvimento:**
   ```sh
   mvn spring-boot:run
   ```

