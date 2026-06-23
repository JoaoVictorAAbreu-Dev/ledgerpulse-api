# LedgerPulse API

API backend para resolver a dor de controle financeiro do dia a dia com alertas, recorrencias e previsibilidade.

## Proposta
- Alertas de contas e assinaturas
- Visao de despesas recorrentes
- Classificacao de gastos por categoria
- Base para previsao e analise de risco financeiro
- Lancamentos de receita e despesa
- Snapshot de saldo projetado
- Indicadores de recorrencia e alerta

## LinkedIn
Projeto voltado para um problema real e facilmente reconhecivel por recrutadores.

## Estrutura
```text
src/main/java/com/jv/financesignal
  config/
  dashboard/
  exception/
  finance/
```

## Endpoints
- `GET /api/health`
- `GET /api/transactions`
- `POST /api/transactions`
- `GET /api/dashboard`

## Regras
- receitas aumentam o saldo projetado
- despesas reduzem o saldo projetado
- recorrencias entram no indicador de risco
- o dashboard sintetiza receita, despesa e alerta

