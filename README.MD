# Gerenciador de Jogos Indie (Estúdio API)

Um sistema para gerenciamento de portfólio de jogos, desenvolvido como laboratório prático para estudo de arquitetura de software, APIs RESTful e integração com banco de dados relacional.

## Objetivo do Projeto
Este projeto foi construído com o objetivo de consolidar os conhecimentos nas camadas tradicionais de uma aplicação web (Backend, Banco de Dados e Frontend). Ele implementa um fluxo CRUD (Create, Read, Update, Delete) completo, garantindo a separação de responsabilidades e a integridade dos dados.

## Tecnologias Utilizadas

**Backend:**
*   **Java 21:** Linguagem principal do projeto.
*   **Spring Boot 3:** Framework para criação ágil da API REST.
*   **Spring Data JPA / Hibernate:** Para mapeamento objeto-relacional (ORM) e comunicação com o banco.
*   **Maven:** Gerenciador de dependências.

**Banco de Dados:**
*   **PostgreSQL:** Banco de dados relacional utilizado para persistência.
*   **pgAdmin 4:** Ferramenta de administração de banco de dados.

**Frontend:**
*   **HTML5 & CSS3:** Estruturação e estilização da interface.
*   **JavaScript (Vanilla):** Consumo da API via requisições assíncronas (`fetch`) e manipulação do DOM.

## Arquitetura e Conceitos Aplicados

O projeto foi estruturado seguindo o padrão de camadas MVC (Model-View-Controller adaptado para REST API), focando na organização do código:
*   **Entity (`Game.java`):** Mapeamento direto das tabelas do banco de dados, utilizando anotações JPA.
*   **Repository (`GameRepository.java`):** Abstração da camada de persistência, evitando a escrita manual de queries SQL.
*   **Controller (`GameController.java`):** Exposição dos endpoints da API, recebimento de requisições HTTP e retorno de códigos de status adequados (`ResponseEntity`).
*   **Tratamento de Exceções:** Implementação de blocos `Try-Catch` para capturar erros de integridade referencial (`DataIntegrityViolationException`) ao tentar excluir registros com chaves estrangeiras vinculadas, retornando mensagens amigáveis ao Frontend.

## Como Executar o Projeto

### Pré-requisitos
*   Java Development Kit (JDK) 21 instalado.
*   PostgreSQL rodando localmente.
*   Uma IDE de sua preferência (VS Code, IntelliJ, Eclipse).

### Passo a Passo
1. Clone este repositório.
2. Abra o PostgreSQL (via pgAdmin ou terminal) e crie um banco de dados chamado `estudio_games_db`.
3. No arquivo `src/main/resources/application.properties`, verifique se o usuário e senha correspondem às credenciais do seu PostgreSQL local:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/estudio_games_db
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update