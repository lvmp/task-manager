# Architecture Decision Record (ADR)

## Título
Uso de Docker e Docker Compose para desenvolvimento local

## Status
Proposto

## Contexto
O PRD em `Docs/PRD.md` especifica a necessidade de uma implantação escalável e de um ambiente de desenvolvimento consistente. Variabilidades de sistemas operacionais e versões de dependências podem gerar inconsistências entre ambientes.

## Decisão
Adotar Docker para containerização de cada serviço (backend, frontend, banco de dados). Utilizar um arquivo `docker-compose.yml` na raiz do repositório para orquestrar todos os containers localmente com configurações standard:

```yaml
version: '3.8'
services:
  backend:
    build: ./backend
    ports:
      - '8080:8080'
    environment:
      - SPRING_PROFILES_ACTIVE=local
  frontend:
    build: ./frontend
    ports:
      - '3000:3000'
    environment:
      - NEXT_PUBLIC_API_URL=http://localhost:8080
  db:
    image: postgres:15
    ports:
      - '5432:5432'
    environment:
      - POSTGRES_USER=task_manager
      - POSTGRES_PASSWORD=secret
      - POSTGRES_DB=task_manager
```

## Consequências
- Ambiente de desenvolvimento padronizado e isolado
- Facilidade de onboarding de novos desenvolvedores
- Dependência de Docker instalado localmente
- Configuração inicial de performance e volumes a ser ajustada conforme necessidade 