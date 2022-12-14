# Desafio Serasa

Este projeto tem como objeto Criar um serviço do tipo API REST, para cadastro de pessoas com
score e suas regiões de afinidades.

As APIs foram documentadas com Swagger com padrão openapi.

O projeto foi desenvolvido com as tecnologias Java, Maven, banco de dados embarcado H2, e, principalmente, Spring Boot. Para desenvolvimento, a IDE utilizada foi a intellij e Insomnia para testes integrados de API.




## Stack utilizada

**Back-end:** Java 11, H2, Spring Boot (Security, Data, Web), Swagger


## Autores

- [@carlosmcp](https://www.github.com/carlosmcp)


## Rodando localmente

Clone o projeto

```bash
  git clone git@github.com:carlosmcp/Desafio-serasa.git
```

Entre no diretório do projeto

```bash
  cd Desafio-Serasa
```

Instale as dependências

```bash
  mvn install
```

Acessar Swagger

```bash
 http://localhost:8080/api/v1/swagger-ui/index.html
```

Acessar H2

```bash
  http://localhost:8080/api/v1/h2-console/
```
Insomnia e plugin (necessário) - Arquivo de rotas: "Insomnia_2022-12-14.json"

```bash

  https://insomnia.rest/download
  https://insomnia.rest/plugins/insomnia-plugin-path-parameters
```
