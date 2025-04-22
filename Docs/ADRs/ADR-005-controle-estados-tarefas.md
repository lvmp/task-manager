# Architecture Decision Record (ADR)

## Título
Definir controle de estados de tarefas

## Status
Proposto

## Contexto
O sistema de tarefas do Task Manager, conforme especificado no PRD (`Docs/PRD.md`), requer um fluxo de estados bem definido para cada tarefa, garantindo rastreabilidade e consistência no progresso.

## Decisão
Implementar um finite state machine (FSM) simples com três estados:
1. **Pendente**: tarefa criada e aguardando início
2. **Em Progresso**: tarefa em desenvolvimento ou execução
3. **Concluída**: tarefa finalizada com êxito

Transitions permitidas:
- Pendente → Em Progresso
- Em Progresso → Concluída
- (Opcional) Concluída → Pendente (reabertura de tarefa)

## Consequências
- Fluxo de trabalho claro e documentado
- Facilita filtros e relatórios com base em estados
- Possível necessidade de versionamento de estados se novos estados forem adicionados no futuro 