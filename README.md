# 💬 Chats E2E - Cassandra + Spring Boot

🚀 **Chats E2E** é um sistema de **mensageria segura** com
**criptografia de ponta a ponta** (E2E) utilizando **Spring Boot** no
backend e **Apache Cassandra** como banco de dados distribuído.\
O projeto é ideal para aplicações de chat em tempo real que necessitam
**escalabilidade**, **baixa latência** e **segurança**.

------------------------------------------------------------------------

## 🛠️ Tecnologias Utilizadas

-   **Java 21** ☕
-   **Spring Boot** ⚡
-   **Apache Cassandra** 🗄️
-   **Spring Data Cassandra**
-   **WebSocket** 🔌
-   **Lombok** 🧩
-   **Maven** 📦

------------------------------------------------------------------------

## 📂 Estrutura do Projeto

    chats-ee2e-bd-cassandra-springboot/
    ├── src/
    │   ├── main/
    │   │   ├── java/com/mkawan/chats/
    │   │   ├── resources/
    │   │   │   ├── application.yml
    │   │   │   └── schema.cql
    │   └── test/
    ├── pom.xml
    └── README.md

## Imagens Test

<img width="1366" height="768" alt="Captura de tela de 2024-11-07 19-59-29" src="https://github.com/user-attachments/assets/35575ef8-078f-4680-a8ad-ccb98e808985" />

<img width="1366" height="768" alt="Captura de tela de 2024-11-30 00-43-48" src="https://github.com/user-attachments/assets/aa77ed0b-f25f-4c8b-8656-40355a34f44a" />

<img width="1366" height="768" alt="Captura de tela de 2024-11-30 00-47-59" src="https://github.com/user-attachments/assets/4cfa541b-5dac-4069-83bd-fe67d4975bca" />

<img width="1366" height="768" alt="Captura de tela de 2024-11-30 00-51-09" src="https://github.com/user-attachments/assets/3e67b03c-5f62-4dbb-b658-75d60d6e4711" />


------------------------------------------------------------------------

## ⚙️ Pré-requisitos

Antes de rodar o projeto, certifique-se de ter instalado:

-   **Java 21+**
-   **Apache Maven**
-   **Apache Cassandra** (3.11 ou 4.0)
-   **Docker** *(opcional, para subir Cassandra)*

------------------------------------------------------------------------

## 🔧 Configuração do Apache Cassandra

### 🟢 1. Subindo o Cassandra via Docker

``` bash
docker run --name cassandra -p 9042:9042 -d cassandra:4.0
```

### 🟢 2. Criando Keyspace e Tabelas

``` sql
CREATE KEYSPACE chats WITH replication = {'class':'SimpleStrategy', 'replication_factor':1};

USE chats;

CREATE TABLE messages (
    id UUID PRIMARY KEY,
    sender TEXT,
    receiver TEXT,
    content TEXT,
    timestamp TIMESTAMP
);
```

------------------------------------------------------------------------

## 🚀 Rodando o Projeto

``` bash
# Clonar o repositório
git clone https://github.com/MKawan/chats-ee2e-bd-cassandra-springboot.git

# Entrar na pasta do projeto
cd chats-ee2e-bd-cassandra-springboot

# Rodar com Maven
mvn spring-boot:run
```

O servidor iniciará em:\
🔗 **http://localhost:8080**

------------------------------------------------------------------------

## 📡 Endpoints Principais

  Método   Endpoint        Descrição
  -------- --------------- --------------------------
  GET      /api/messages   Lista todas as mensagens
  POST     /api/messages   Envia uma nova mensagem
  GET      /api/users      Lista todos os usuários

------------------------------------------------------------------------

## 🗄️ Estrutura do Banco Cassandra

  Campo       Tipo        Descrição
  ----------- ----------- --------------------------
  id          UUID        Identificador único
  sender      TEXT        Remetente da mensagem
  receiver    TEXT        Destinatário da mensagem
  content     TEXT        Conteúdo da mensagem
  timestamp   TIMESTAMP   Data/hora do envio

------------------------------------------------------------------------

## 🛣️ Próximos Passos

-   🔐 Implementar autenticação JWT
-   📡 Suporte a WebSockets para mensagens em tempo real
-   📦 Deploy na AWS com ECS + Cassandra gerenciado
-   📱 Criar cliente React Native

------------------------------------------------------------------------

## 👨‍💻 Autor

Feito com ❤️ por **MKawan**\
📌 [GitHub](https://github.com/MKawan)

------------------------------------------------------------------------

> ⚡ *Chats E2E - Segurança, velocidade e escalabilidade em um só
> projeto.*
