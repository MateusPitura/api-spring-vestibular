<h1 align="center"> 
  <p>Vest Info - REST API</p> 
</h1> 

<p> 
  <img src="https://img.shields.io/badge/Release-Abr%202024-green" alt="Badge da data de lançamento: Abril de 2024">  
  <img src="https://img.shields.io/badge/Version-0.1.0-blue" alt="Badge da versão do projeto: 0.1.0">  
  <img src="https://img.shields.io/badge/Status-Closed-brightgreen" alt="Badge do status: fechado">  
  <img src="https://img.shields.io/github/stars/MateusPitura/api-spring-vestibular?style=social" alt="Badge indicando quantidade de estrelas no repositório"> 
</p> 

## Descrição 

Este projeto consiste em uma REST API desenvolvida em Spring Boot para suportar o aplicativo [Vest Info](https://github.com/MateusPitura/app-reactnative-vestibular). Ela fornece endpoints para o consumo de universidades, eventos e avisos dos principais vestibulares de Ponta Grossa - PR

O projeto possui duas branches. `main` para ser executada locamente sem compilação, com autenticação e CRUD completo. `sever` para ser executada em servidores, com apenas o GET liberado

## Índice 

- [Funcionalidades](#funcionalidades) 
- [Como executar](#como-executar) 
- [Tecnologias usadas](#tecnologias-usadas) 
- [Autores](#autores) 

## Funcionalidades 

:cloud: **Cloud:** hospedagem em servidores Oracle

:key: **Segurança:** proteção com JWT

:floppy_disk: **Autonomous Database:** base de dados relacional automatizada

## Como executar 

Acesse a documentação da API no [Postman](https://documenter.getpostman.com/view/28639415/2sA3Bobrpw) para aprender a utilizar

**Para devs | main:** 

1. Crie duas variáveis de ambiente: `DATA_BASE` com a senha da wallet e `API_KEY_VESTIBULARES` com um valor qualquer

2. Mova a wallet para o mesmo diretório da pasta raiz do projeto

3. Garanta que o firewall para a porta 3000 esteja livre e desabilitado

**Para devs | server:** 

1. No arquivo `application.properties` altere `<password>` pela senha da wallet e `<path>` pelo caminho absoluto dela

2. Dê permissão para o JAR ser executado com `chmod +x api-0.0.1-SNAPSHOT.jar`

3. Garanta que o firewall para a porta 3000 esteja livre e desabilitado
 
4. Mova o arquivo `src/main/resources/api-spring-vestibular.service` para `/etc/systemd/system/`. Reinicie com `systemctl daemon-reload` e execute com `systemctl start api-spring-vestibular.service`. Altere o arquivo para apontar para um caminho do JAR diferente caso necessário

## Tecnologias usadas 

:heavy_check_mark: Java 17 

:heavy_check_mark: Spring
 
:heavy_check_mark: Oracle Cloud Infrastructure

:heavy_check_mark: Autonomous Database

## Autores 

| Mateus Pitura | 
|------| 
| <p align="center"><img src="https://avatars.githubusercontent.com/u/119008106" width="100" height="100"></p> | 
| <a href="https://www.linkedin.com/in/mateuspitura/"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white"> |
