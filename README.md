# pedeai-auth

Serviço de autenticação e gerenciamento de usuários desenvolvido em Java com Spring Boot.

## Principais Tecnologias

- **Spring Boot**
- **Spring Data JPA**
- **Spring Security**
- **Swagger/OpenAPI** (Documentação automática)
- **Docker** (Containerização)
- **Maven** (Build e dependências)
- **H2 Database** (Ambiente de desenvolvimento)

## Práticas Adotadas

- **API First**: Contratos definidos antes da implementação, gerando interfaces via Swagger Codegen.
- **SOLID**: Código modular, testável e fácil de manter.
- **Documentação automática**: Disponível via Swagger UI.
- **Testes manuais e automatizados**: Cobrem inicialização, endpoints, autenticação, integração e tratamento de erros.

## Como executar

```bash
# Build do projeto
mvn clean package

# Executar com Docker
docker build -t pedeai-auth .
docker run -p 8080:8080 pedeai-auth

# Executar baixando a imagem diretamente do Docker Hub
docker login
docker compose up –d 

A aplicação será acessível pela URL:  
 http://localhost:8080/ 
