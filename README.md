# :calendar: Bem-vindo ao AgendamentoApp :alarm_clock:
Serviço responsável por cadastrar agendamentos de serviços para clientes

- [X] Backend - API Rest
- [ ] Frontend

# Ambiente de desenvolvimento
Existem alguns passos para execução do projeto em ambiente local, necessário que alguns programas estejam corretamente instalados.

Framework/lib | Versão Recomendada | S.O Utilizado
--- | --- | ---
Maven	| 3.6.3	| Windows
JDK	| 8	| Windows
Docker	| 19.03.13 | Windows
Docker Compose |	1.27.4	| Windows
Intellij	| -	| Windows

## Execução do projeto
### Passo 1
Faça o clone do projeto
```shell script
$ git clone https://github.com/pauloruszel/desafio-maplink.git agendamentoapp
```
### Passo 2
Entre na pasta raiz do projeto

```shell script
$ cd agendamentoapp
```
### Passo 3
Executar o comando do maven para gerar o artefato que será publicado no docker
```shell script
$ cd mvn clean install
```
### Passo 4
Execute o comando para levantar toda infraestrutura necessária

```shell script
$ docker-compose up --build
```
Acompanhar logs:
```shell script
$ docker-compose logs -f
```

# Serviços do desafio-maplink

Serviço	| URL	| Status | Descrição
--- | --- | --- | ---
Clientes	| http://localhost:8080/api/v1/clientes	| ✅	| Endpoint de cliente
Serviços	| http://localhost:8080/api/v1/servicos	| ✅	| Endpoint de serviço
Agendamentos	| http://localhost:8080/api/v1/agendamentos	| ✅	| Endpoint para agendamento

# Exemplo de requisições para os Endpoints
## Endpoint de clientes
### Url de requisição:

http://localhost:8080/api/v1/clientes
### Envio
```shell script
{
    "valor": "100.0",
    "descricao": "Atendimento",
    "codigo": "01"
}
```
### Retorno:
```shell script
  {
    "data": [
        {
            "id": 1,
            "codigo": "01",
            "descricao": "Atendimento",
            "valor": "100.0"
        }
    ]
}
```
