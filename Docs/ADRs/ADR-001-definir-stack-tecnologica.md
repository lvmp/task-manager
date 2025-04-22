# Architecture Decision Record (ADR)

## Título
Definir stack tecnológica

## Status
Proposto

## Contexto
Conforme o PRD em Docs/PRD.md, o projeto Task Manager requer definição clara da stack tecnológica. O backend deve ser implementado em Kotlin + Spring Boot, e o frontend em Next.js. Além disso, é necessário padronizar a arquitetura interna: Clean Architecture no backend e Storybook para testes de componentes no frontend.

## Decisão
Adotar Kotlin 1.9 + Spring Boot 3.2 no backend, estruturado seguindo princípios de Clean Architecture. No frontend, usar Next.js 14 com TypeScript, e integrar Storybook para testes e documentação visual de componentes.

## Consequências
- Adoção de Clean Architecture no backend promove separação de camadas e facilita manutenção e testes.
- Uso do Storybook agiliza desenvolvimento e validação de componentes de UI.
- Curva de aprendizado adicional para novos desenvolvedores em Clean Architecture e Storybook.
- Padrão unificado de tecnologia e arquitetura para toda a equipe. 