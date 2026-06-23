# LedgerPulse API

API backend para controle financeiro pessoal com foco em recorrencias, alertas e previsibilidade de saldo.

## Objetivo
Consolidar receitas, despesas e lancamentos recorrentes para permitir leitura rapida de saude financeira e risco de caixa.

## Problema atendido
- despesas e receitas ficam espalhadas
- recorrencias sao esquecidas
- saldo projetado nao e acompanhado com consistencia
- alertas financeiros surgem tarde demais

## Escopo funcional
- autenticacao com JWT
- cadastro e listagem de transacoes
- snapshot de saldo
- contagem de recorrencias
- score de alerta financeiro

## Stack
- Java 21
- Spring Boot
- Spring Security com JWT
- Spring Data JPA
- PostgreSQL em producao
- H2 em testes

## Regras de negocio
- receitas aumentam o saldo projetado
- despesas reduzem o saldo projetado
- recorrencias elevam o risco de alerta
- o dashboard sintetiza volume, saldo e recorrencia

## Credenciais de demo
- email: `demo@ledgerpulse.dev`
- senha: `ledger123`

## Variaveis de ambiente
- `DATABASE_URL`
- `DATABASE_USERNAME`
- `DATABASE_PASSWORD`
- `JWT_SECRET`
- `JWT_EXPIRATION_MINUTES`

## Como executar
1. suba o PostgreSQL com `docker compose up -d`
2. configure as variaveis de ambiente
3. execute `mvn spring-boot:run`

## Como testar
```bash
mvn test
```

## Endpoints principais
- `GET /api/health`
- `POST /api/auth/login`
- `GET /api/transactions`
- `POST /api/transactions`
- `GET /api/dashboard`

## Estrutura do projeto
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

## Decisoes tecnicas
- controllers finos
- regras concentradas em services
- DTOs para entrada e saida
- tratamento centralizado de erros
- persistencia relacional com UUID
- rotas protegidas por JWT

## Evolucao prevista
- parcelas e vencimentos
- categorias customizadas
- metas de economia
- alertas de limite por categoria
