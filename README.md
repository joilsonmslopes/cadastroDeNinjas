
# Cadastro de Ninjas

Sistema desenvolvido em Java com Spring Boot para gerenciar o cadastro de Ninjas e suas Missões.

## 📋 Descrição

Este projeto é uma API RESTful que permite:

- ✅ Cadastrar e listar Ninjas.
- ✅ Cadastrar e listar Missões.
- ✅ Atualizar e excluir registros.
- ✅ Utilização de DTOs e Mappers para desacoplar as entidades das representações de dados.
- ✅ Estrutura modular, separando responsabilidades de Controllers, Services, Repositories e Models.

## 🏗️ Estrutura do Projeto

```
CadastroDeNinjas/
├── CadastroDeNinjasApplication.java
├── Missions/
│   ├── MissionController.java
│   ├── MissionDTO.java
│   ├── MissionMapper.java
│   ├── MissionModel.java
│   ├── MissionRepository.java
│   └── MissionService.java
└── Ninjas/
    ├── NinjaController.java
    ├── NinjaDTO.java
    ├── NinjaMapper.java
    ├── NinjaModel.java
    ├── NinjaService.java
    └── NinjasRepository.java
```

## 🚀 Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Lombok
- H2 Database (ou outro banco relacional)
- Maven

## 📦 Funcionalidades

### 🔹 Ninjas
- Criar Ninja
- Listar todos os Ninjas
- Atualizar dados de um Ninja
- Deletar Ninja

### 🔹 Missões
- Criar Missão
- Listar todas as Missões
- Atualizar Missão
- Deletar Missão

## 🧱 Padrões e Boas Práticas

- **DTOs**: Representação dos dados trafegados pela API.
- **Mappers**: Conversão entre Model e DTO.
- **Service Layer**: Lógica de negócios isolada.
- **Repository**: Acesso aos dados com Spring Data JPA.
- **Controller**: Camada responsável por expor as rotas REST.

## ▶️ Como executar o projeto

1. Clone o repositório:
   ```bash
   HTTPS: git clone https://github.com/joilsonmslopes/cadastroDeNinjas.git
   ou
   SSH: git clone git@github.com:joilsonmslopes/cadastroDeNinjas.git
   cd CadastroDeNinjas
   ```

2. Abra no IntelliJ, Eclipse ou outro IDE Java.

3. Certifique-se de ter o Java 21+ instalado.

4. Execute a classe `CadastroDeNinjasApplication`.

5. Acesse a API via Postman ou outra ferramenta, utilizando as rotas expostas.

## 🛠️ Configurações importantes

- Banco de dados em memória H2 ou configurável via `application.properties`.
- O projeto segue a estrutura de camadas para melhor organização e manutenção.

## 🤝 Contribuições

Sinta-se à vontade para contribuir com melhorias, correções de bugs ou novas funcionalidades!

## 📄 Licença

Este projeto é de livre uso para fins educacionais.
