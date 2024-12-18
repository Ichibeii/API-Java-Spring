# 📋 API REST de Gerenciamento de Pessoas

Este é um projeto de uma API REST desenvolvida com **Java Spring Boot**, que realiza o gerenciamento de pessoas. A aplicação possui funcionalidades como CRUD, filtragem por nome e geração de relatórios em PDF. Além disso, foram implementados testes automatizados para garantir a qualidade do código.

---

## ✨ **Funcionalidades**
- Criar, listar, atualizar e excluir pessoas.
- Filtrar pessoas pelo **nome**.
- Geração de relatórios de pessoas cadastradas em **PDF**.
- Testes automatizados para validação das funcionalidades.

---

## 🛠️ **Tecnologias Utilizadas**
- **Java** (linguagem principal do projeto)
- **Spring Boot** (framework para simplificar o desenvolvimento da API REST)
- **MySQL** (banco de dados para persistência das informações)
- **iText** (biblioteca para geração de relatórios em PDF)


---

# Endpoints da API

## 1. **POST /ManagementPeoples**
Cria um novo cadastro de pessoa.

**Request:**
```json
{
  "name": "Carlos Silva",
  "cpf": 12345678901,
  "email": "carlos.silva@example.com",
  "numero": "123456789"
}
```

## 2. **GET /ManagementPeoples**

Lista de pessoas cadastradas.

**Request**
```json
[
  {
    "id": 1,
    "name": "Carlos Silva",
    "cpf": 12345678901,
    "email": "carlos.silva@example.com",
    "numero": "123456789"
  },
  {
    "id": 2,
    "name": "Maria Souza",
    "cpf": 98765432100,
    "email": "maria.souza@example.com",
    "numero": "987654321"
  }
]
```

## 3. **PUT /ManagementPeoples/atualizacao**

Atualiza os dados.

**Request**
```json
{
  "id": 1,
  "name": "André Silva",
  "cpf": 12345678901,
  "email": "andre.silva@example.com",
  "numero": "123456789"
}
```

## 4. **DELETE /ManagementPeoples/{id}**

Deletar um cadastro através do id passado.

**Request**

```http
DELETE /ManagementPeoples/1
```

## 5. **GET /ManagementPeoples/{name}**

Buscar pelo nome de uma pessoa cadastrada

**Request**

```http
ManagementPeoples/Andre
```

##Visualização do documento em PDF exemplo:

![Visualização em PDF](https://github.com/user-attachments/assets/3a620fb6-fd93-4713-a494-e5ad77538aab)

