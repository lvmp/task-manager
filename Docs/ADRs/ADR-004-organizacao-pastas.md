# Architecture Decision Record (ADR)

## Título
Definir organização de pastas

## Status
Proposto

## Contexto
Conforme o PRD em `Docs/PRD.md`, é necessária uma estrutura de pastas clara para separar código de backend, frontend, documentação e configurações. Isso facilita manutenção, onboarding e automações de CI/CD.

## Decisão
Adotar a seguinte organização de pastas no monorepo:
- `backend/`: código-fonte Kotlin + Spring Boot
- `frontend/`: código-fonte Next.js
- `Docs/`: documentação (PRD, ADRs, etc.)
- `configs/`: arquivos de configuração (docker-compose.yml, etc.)
- `scripts/`: scripts de build, migrations e automações
- `.github/`: workflows de CI/CD
- `tests/`: testes end-to-end e de integração

## Consequências
- Navegação e manutenção simplificadas
- Facilita automações e integração com ferramentas de CI/CD
- Curva de aprendizado inicial para novos colaboradores quanto à estrutura 