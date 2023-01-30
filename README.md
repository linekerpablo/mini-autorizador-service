# Mini Autorizador
## Por Lineker Pablo da Silva - @linekerpablo@gmail.com

Mini autorizador criado com a finalidade de expor meu conhecimento de desenvolvimento com java + spring boot.

## Features

- Cadastrar cartão
- Buscar saldo do cartão
- Criar uma nova transação para o cartão
- Validar concorrência na hora de criar transação e barrar

## Tecnologias

O que foi utilizado para desenvolver a aplicação?

- [Java] - 11 com Spring Boot
- [MySQL] - Banco free da db4free
- [Docker] - Dockerfile configurado para fazer da aplicação dockerizada
- [Servidor] - Utilizei o gitflow com actions do github para fazer o deploy automatizado (CI/CD) na Heroku sempre que for feito um push na branch master

## Acesso da aplicação

Como configurei deploy automatizado com gitflow actions, basta fazer um push na branch master que o código é atualizado automaticamente no servidor.

Abaixo url do swagger para testar a api:

Server-Heroku: https://mini-autorizador-service.herokuapp.com/swagger-ui/index.html

## Pacotes

Abaixo alguns pacotes utilizados na aplicação:

| Pacote |
| ------ |
| spring-boot-starter-data-jpa |
| spring-boot-starter-web |
| springdoc-openapi-ui |
| springdoc-openapi-data-rest |
| mysql-connector-java |
| hibernate-core |
| lombok |