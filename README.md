# springboot-jwt-auth-app

Aplicação Spring Boot para cadastro e autenticação de usuários utilizando JWT.

## Funcionalidades
- Cadastro de usuários
- Autenticação via JWT
- Criptografia de senhas com BCrypt
- Integração com PostgreSQL

## Instalação
1. Clone o repositório:
   ```
   git clone https://github.com/PedroCauax/springboot-jwt-auth-app.git
   ```
2. Configure o banco de dados em `application.properties`.
3. Execute:
   ```
   ./mvnw spring-boot:run
   ```

## Endpoints principais
- `POST /auth/register` — Cadastro de usuário
- `POST /auth/login` — Autenticação e geração de token JWT

## Licença
MIT
