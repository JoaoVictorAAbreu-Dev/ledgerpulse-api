# LedgerPulse API

API backend para controle financeiro pessoal com foco em recorrencias, alertas e previsibilidade de saldo.

## Problema que resolve
- centraliza receitas e despesas
- evidencia contas recorrentes
- ajuda a prever saldo projetado
- cria base para alertas financeiros

## Stack
- Java 21
- Spring Boot
- Spring Security com JWT
- Spring Data JPA
- PostgreSQL
- H2 para testes

## Funcionalidades
- login com usuario demo
- cadastro e consulta de transacoes
- snapshot de saldo e alertas
- seguranca com JWT

## Credenciais de demo
- email: `demo@ledgerpulse.dev`
- senha: `ledger123`

## Variaveis de ambiente
- `DATABASE_URL`
- `DATABASE_USERNAME`
- `DATABASE_PASSWORD`
- `JWT_SECRET`
- `JWT_EXPIRATION_MINUTES`

## Execucao local
1. subir PostgreSQL com `docker compose up -d`
2. configurar variaveis de ambiente
3. executar `mvn spring-boot:run`

## Testes
```bash
mvn test
```

## Estrutura principal
```text
src/main/java/com/jv/financesignal
  auth/
  config/
  dashboard/
  exception/
  finance/
  security/
  user/
```

## Endpoints
- `GET /api/health`
- `POST /api/auth/login`
- `GET /api/transactions`
- `POST /api/transactions`
- `GET /api/dashboard`

## Observacoes de arquitetura
- controllers sem regra de negocio
- validacao com Bean Validation
- tratamento centralizado de erros
- usuarios demo persistidos em banco
- rotas protegidas por JWT

## Valor para LinkedIn
Projeto forte para demonstrar backend financeiro com persistencia, autenticacao, testes e previsibilidade de saldo.
