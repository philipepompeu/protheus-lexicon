# Protheus Lexicon

Este projeto tem como objetivo fornecer uma aplica��o web para consulta e compara��o de dicion�rios do Protheus.

## Frontend

### Requisitos M�nimos
- Node.js (vers�o 16 ou superior)
- NPM (vers�o 8 ou superior) ou Yarn
- Vue CLI

### Passo-a-Passo
1. **Instalar depend�ncias do projeto:**
   ```sh
   cd frontend
   npm install
   ```
2. **Executar o projeto localmente:**
   ```sh
   npm run serve
   ```
   - O frontend ser� executado em `http://localhost:8082/`

3. **Gerar build para produ��o:**
   ```sh
   npm run build
   ```

## Backend

### Requisitos M�nimos
- Java 17 ou superior
- Maven
- PostgreSQL (com um banco de dados criado)

### Passo-a-Passo
1. **Configurar o banco de dados:**
   - Criar um banco no PostgreSQL
   - Atualizar as credenciais no `application.properties`

2. **Compilar e executar o backend:**
   ```sh
   cd backend
   mvn clean package
   java -jar target/protheus-lexicon.jar
   ```
   - O backend ser� executado em `http://localhost:8080/`

3. **Executar em modo desenvolvimento:**
   ```sh
   mvn spring-boot:run
   ```

