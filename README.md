DSList Project
---

### Descrição

Este é um projeto de estudo desenvolvido durante o curso "Intensivão Java Spring" ministrado pelo professor Nélio Alves.

DSList é um projeto desenvolvido utilizando Java, Spring Boot e Maven que fornece uma API RESTful para gerenciar listas de jogos, permitindo que os usuários recuperem e manipulem dados de jogos.

---

### Tecnologias Utilizadas
- Java 17
- Spring Boot (latest)
- Maven (latest)
- MySQL (latest)
- Lombok (latest)

---

### Exemplos de Requisição no Ambiente de Produção

1. **Recuperar todas as listas de jogos:**
   ```http
   GET https://dslist-production-f3c0.up.railway.app/lists

---

### Instalação
1. Clone o repositório
```sh
git clone https://github.com/barbarastefany/dslist.git
```
2. Navegue até o diretório do projeto:
```sh
cd dslist
```
3. Configure o banco de dados no arquivo **application-dev.yml**
```sh
spring:
  datasource:
    url: jdbc:mysql://localhost:3307/dslist
    username: seu_usuario
    password: sua_senha
```
4. Faça a build do projeto
```sh
mvn clean install
```
5. Execute o projeto
```sh
mvn spring-boot:run
```

---

## Endpoints

| método  | endpoint                                           | descrição                                 |
|---------|----------------------------------------------------|-------------------------------------------|
| `GET`   | `http://localhost:8080/games`                      | Recuperar todas as listas de jogos        |
| `GET `  | `http://localhost:8080/games/{id}`                 | Recuperar um jogo pelo id                 |
| `GET`   | `http://localhost:8080/lists/{listId}/games`       | Retorna os jogos de uma lista específica  |
| `GET`   | `http://localhost:8080/lists`                      | Retorna as listas existentes              |
| `POST`  | `http://localhost:8080/lists/{listId}/replacement` | Altera a posição de um jogo em uma lista  |

No endpoint de `replacement`, deve-se colocar um corpo de requisição com o `index de origem (sourceIndex)` e o `index de destino (destinationIndex)` do jogo na lista.

```
{
  "sourceIndex": 1,
  "destinationIndex": 3
}
```

---

## Deploy

### Ambiente de Produção
A aplicação está hospedada na plataforma Railway e pode ser acessada através do seguinte link:

**URL Base:**  
[https://dslist-production-f3c0.up.railway.app](https://dslist-production-f3c0.up.railway.app)

### Exemplo de Requisição no Ambiente de Produção

| método  | endpoint                                              | descrição                                 |
|---------|-------------------------------------------------------|-------------------------------------------|
| `GET`   | `https://dslist-production-f3c0.up.railway.app/lists` | Recuperar todas as listas de jogos        |

---

## Licença

Distribuído sob a licença MIT. Veja `LICENSE` para mais informações.



