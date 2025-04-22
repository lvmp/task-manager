# Architecture Decision Record (ADR)

## Título
Estruturar repositório como monorepo

## Status
Proposto

## Contexto
O projeto Task Manager, conforme descrito no PRD em `Docs/PRD.md`, compreende dois módulos principais: backend e frontend. Manter repositórios separados para cada módulo aumenta a complexidade de CI/CD, do versionamento de dependências e da coordenação de mudanças que afetam ambas as partes.

## Decisão
Adotar um monorepo único contendo as seguintes pastas de alto nível:
- `backend/` para a aplicação Kotlin + Spring Boot
- `frontend/` para a aplicação Next.js
- `Docs/` para documentação (PRD, ADRs, etc.)
- `configs/` para arquivos de configuração e scripts (por exemplo, `docker-compose.yml`)
- `scripts/` para automações (migrations, lint, etc.)

Utilizar Gradle multi-módulo no backend e Next.js nativamente no frontend, mantendo um controle de versão unificado para todo o repositório.

## Consequências
- Vantagens:
  - Compartilhamento de configurações comuns de CI/CD e lint
  - Sincronização simplificada de mudanças que afetam ambos os módulos
  - Visão única do projeto para toda a equipe
- Desvantagens:
  - Aumento do tamanho do repositório
  - Possível necessidade de configuração adicional em ferramentas de build
  - Curva de aprendizado para novos colaboradores sobre estrutura monorepo 