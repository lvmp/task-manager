# Backlog de Tarefas

## TASK-001: Criar estrutura monorepo
- Descrição: Criar a estrutura de pastas conforme padrão monorepo (`backend/`, `frontend/`, `Docs/`, `configs/`, `scripts/`, `tests/`, `.github/`).
- Complexidade: baixo
- Dependências: nenhuma
- Status: Concluída
- Comentário: Diretórios `backend/`, `frontend/`, `configs/`, `scripts/`, `tests/` e `.github/` criados conforme ADR-002

## TASK-002: Inicializar projeto backend
- Descrição: Inicializar projeto Spring Boot em Kotlin com Gradle e base de Clean Architecture.
- Complexidade: médio
- Dependências: TASK-001
- Status: Concluída
- Comentário: Projeto backend inicializado via Spring Initializr; pacotes de Clean Architecture criados.
- Subtarefas:
  - TASK-002.1: Criar projeto Spring Boot com Kotlin e Gradle.
  - TASK-002.2: Configurar módulos Gradle multi-módulo.
  - TASK-002.3: Criar pacotes `domain`, `application` e `infrastructure`.

## TASK-003: Inicializar projeto frontend
- Descrição: Criar aplicação Next.js 14 com TypeScript e estrutura básica de pastas.
- Complexidade: médio
- Dependências: TASK-001
- Status: Concluída
- Comentário: Next.js 14 scaffold realizado em `frontend/` com TypeScript, ESLint, App Router, Prettier e diretórios `src/components` e `src/styles` criados.
- Subtarefas:
  - TASK-003.1: Executar `npx create-next-app --typescript --eslint --src-dir --app`.
  - TASK-003.2: Configurar ESLint e Prettier.
  - TASK-003.3: Ajustar estrutura de pastas para componentes, páginas e estilos.

## TASK-004: Integrar Storybook no frontend
- Descrição: Instalar e configurar Storybook para testes e documentação visual de componentes.
- Complexidade: baixo
- Dependências: TASK-003
- Status: Concluída
- Comentário: Storybook instalado como dependência dev e configurado em `frontend/.storybook`.

## TASK-005: Configurar Docker Compose
- Descrição: Criar `docker-compose.yml` na raiz do repositório para orquestrar backend, frontend e PostgreSQL.
- Complexidade: baixo
- Dependências: TASK-001
- Status: Concluída
- Comentário: Arquivo `docker-compose.yml` criado na raiz com serviços backend, frontend e db conforme ADR-003

## TASK-006: Configurar banco de dados PostgreSQL no Docker
- Descrição: Ajustar serviço de banco no `docker-compose.yml` (imagem, variáveis de ambiente, volumes).
- Complexidade: médio
- Dependências: TASK-005
- Status: Concluída
- Comentário: Adicionado named volume `db_data` para persistência de dados do PostgreSQL no `docker-compose.yml`.

## TASK-007: Configurar conexão backend-DB
- Descrição: Configurar datasource do Spring Boot para conectar ao container PostgreSQL.
- Complexidade: médio
- Dependências: TASK-002, TASK-006
- Status: Concluída
- Comentário: Adicionada dependência `org.postgresql:postgresql` em build.gradle.kts e migradas configurações de datasource para `application.yml`.

## TASK-008: Definir entidade Task no backend
- Descrição: Criar `Task` no domínio com atributos (id, título, descrição, prioridade, prazo, estado).
- Complexidade: médio
- Dependências: TASK-002
- Status: Concluída
- Comentário: Implementada entidade `Task` com atributos e criadas enums `Priority` e `Status` no domínio.

## TASK-009: Implementar FSM de estados de tarefa
- Descrição: Criar máquina de estados (Pendente → Em Progresso → Concluída) em camada de domínio.
- Complexidade: médio
- Dependências: TASK-008
- Status: Concluída
- Comentário: FSM baseada no enum `Status` no domínio; Domain-Persistence separado com TaskGateway e TaskMapper. Disponível transição de estados via Service.

## TASK-010: Criar repositórios e serviços de Task
- Descrição: Implementar interfaces de repositório e classes de serviço que executam operações de CRUD e transição de estados.
- Complexidade: alto
- Dependências: TASK-008, TASK-009
- Subtarefas:
  - TASK-010.1: Definir interface TaskRepository.
  - TASK-010.2: Implementar TaskRepository JPA com Spring Data.
  - TASK-010.3: Definir interface TaskGateway e TaskConverter.
  - TASK-010.4: Implementar TaskGatewayImpl e TaskConverterImpl.
  - TASK-010.5: Implementar UseCases (Create, Get, List, Update, Delete, ChangeStatus).
- Status: Concluída
- Comentário: Repositório e entidades criados; Gateway, Converter e UseCases implementados conforme Clean Architecture e SOLID.

## TASK-011: Expor endpoints REST para Task
- Descrição: Criar controllers no Spring Boot para operações de Task (GET, POST, PUT, DELETE).
- Complexidade: médio
- Dependências: TASK-010
- Status: Concluída
- Comentário: `TaskController` ajustado para usar `TaskConverter` e DTOs (`CreateTaskRequest`, `TaskResponse`, `UpdateTaskRequest`, `ChangeTaskStatusRequest`).

## TASK-012: Definir entidade User no backend
- Descrição: Criar modelo `User` (id, nome, e-mail, senha, role) no domínio.
- Complexidade: médio
- Dependências: TASK-002
- Subtarefas:
  - TASK-012.1: Criar `UserEntity` JPA em infraestrutura.
    - Status: Concluída
    - Comentário: `UserEntity` criado com campos id, name, email, password, role, createdAt e updatedAt.
  - TASK-012.2: Criar `UserRepository` com Spring Data JPA.
    - Status: Concluída
    - Comentário: `UserRepository` implementado estendendo JpaRepository<UserEntity, Long>.
  - TASK-012.3: Criar `UserConverter` domain↔entity.
    - Status: Concluída
    - Comentário: Interface `UserConverter` criada em application.converter.
  - TASK-012.4: Criar `UserGateway` e implementação.
    - Status: Concluída
    - Comentário: Implementado `UserGatewayImpl` usando `UserRepository` e `UserConverter`.
  - TASK-012.5: Criar usecases de registro (`RegisterUserUseCase`) e autenticação (`AuthenticateUserUseCase`).
    - Status: Concluída
    - Comentário: Implementados `RegisterUserUseCaseImpl` e `AuthenticateUserUseCaseImpl` com `PasswordEncoder`.
  - TASK-012.6: Adicionar `PasswordEncoder` com BCrypt para criptografia de senha.
    - Status: Concluída
    - Comentário: Bean `PasswordEncoder` configurado em `SecurityConfig` com `BCryptPasswordEncoder`.
- Status: Concluída
- Comentário: Entidade `User`, persistência, gateway, converter, use cases e criptografia de senha implementados com sucesso.

## TASK-013: Implementar autenticação JWT
- Descrição: Configurar Spring Security com JWT, endpoints de login e refresh token.
- Complexidade: alto
- Dependências: TASK-012
- Subtarefas:
  - TASK-013.1: Adicionar dependências Spring Security e JWT no build.
  - TASK-013.2: Configurar filtros e providers JWT.
  - TASK-013.3: Implementar AuthController com endpoint /login.
  - TASK-013.4: Implementar endpoint /refresh-token.
  - TASK-013.5: Escrever testes unitários de autenticação.

## TASK-014: Expor endpoints de usuário
- Descrição: Criar controllers para registro, login e refresh de token.
- Complexidade: médio
- Dependências: TASK-013

## TASK-015: Implementar UI de login e registro
- Descrição: Criar páginas React/Next.js para login e registro usando Fetch API.
- Complexidade: médio
- Dependências: TASK-003, TASK-014

## TASK-016: Configurar contexto de autenticação no frontend
- Descrição: Gerenciar tokens JWT, armazenamento (localStorage) e proteção de rotas.
- Complexidade: médio
- Dependências: TASK-015

## TASK-017: Implementar UI de listagem de tarefas
- Descrição: Criar página de listagem de tarefas com filtros por estado, prioridade e prazo.
- Complexidade: médio
- Dependências: TASK-003, TASK-011, TASK-016

## TASK-018: Criar UI de criação/edição de tarefas
- Descrição: Criar formulário para adicionar e editar tarefas, incluindo seleção de prioridade e prazo.
- Complexidade: médio
- Dependências: TASK-011, TASK-016

## TASK-019: Adicionar filtros de tarefas no frontend
- Descrição: Implementar funcionalidade de filtro de tarefas por estado e prioridade.
- Complexidade: baixo
- Dependências: TASK-017

## TASK-020: Escrever testes unitários no backend
- Descrição: Criar testes unitários JUnit + Mockk para TaskGatewayImpl e para cada UseCase de Task.
- Complexidade: médio
- Dependências: TASK-011, TASK-013
- Subtarefas:
  - TASK-020.1: Criar testes unitários para TaskGatewayImpl.
  - TASK-020.2: Criar testes unitários para TaskConverterImpl.
  - TASK-020.3: Criar testes unitários para CreateTaskUseCaseImpl.
  - TASK-020.4: Criar testes unitários para GetTaskUseCaseImpl.
  - TASK-020.5: Criar testes unitários para ListTasksUseCaseImpl.
  - TASK-020.6: Criar testes unitários para UpdateTaskUseCaseImpl.
  - TASK-020.7: Criar testes unitários para DeleteTaskUseCaseImpl.
  - TASK-020.8: Criar testes unitários para ChangeTaskStatusUseCaseImpl.

## TASK-021: Escrever testes de componentes no frontend
- Descrição: Criar stories e testes unitários de UI com Storybook e Jest.
- Complexidade: médio
- Dependências: TASK-004

## TASK-022: Planejar pipeline CI/CD inicial
- Descrição: Esboçar workflow do GitHub Actions para build, testes e deploy futuro.
- Complexidade: alto
- Dependências: TASK-005, TASK-013, TASK-020, TASK-021
- Subtarefas:
  - TASK-022.1: Criar workflow de build para backend no GitHub Actions.
  - TASK-022.2: Criar workflow de build para frontend no GitHub Actions.
  - TASK-022.3: Adicionar execução de testes automatizados (JUnit, Jest).
  - TASK-022.4: Integrar cobertura de código no pipeline.
  - TASK-022.5: Documentar processo de deploy futuro. 