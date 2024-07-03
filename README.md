# Agrix - Fase C (Final)

## Confira todas as fases do projeto aqui:

| Fase   | Link                                                            |
| ------ | --------------------------------------------------------------- |
| Fase A | [Fase A](https://github.com/lucas-de-lima/projeto-agrix-fase-a) |
| Fase B | [Fase B](https://github.com/lucas-de-lima/projeto-agrix-fase-b) |
| Fase C | [Fase C](https://github.com/lucas-de-lima/projeto-agrix-fase-c) |

## Apresentação do Projeto

O projeto Agrix tem como objetivo desenvolver uma API robusta e segura para gerenciar informações agrícolas, como fazendas, culturas e fertilizantes. Na [Fase C](https://github.com/lucas-de-lima/projeto-agrix-fase-c), foquei na implementação de segurança para proteger as rotas da aplicação, garantindo que apenas usuários autenticados e autorizados possam acessar determinados recursos. Utilizei o Spring Security para gerenciar a autenticação e autorização, incluindo a geração de tokens JWT para sessões seguras.

## Especificações do Projeto

Nesta fase, migrei o código da [Fase B](https://github.com/lucas-de-lima/projeto-agrix-fase-b) para o novo projeto, adicionei novas rotas e implementei uma camada de segurança robusta utilizando Spring Security. A seguir, detalhei cada um dos requisitos cumpridos nesta fase:

### 1. Criação da Rota POST /persons

<details>
	 <summary>📍🌐 Detalhes da Rota: </summary><br />

Implementei a rota POST /persons para permitir o cadastro de novas pessoas na aplicação. Esta rota integra a API com o código existente e possibilita a criação de usuários com diferentes roles.

**Definição da rota:**

- **/persons (POST)**
  - Recebe no corpo da requisição:
    - `username`
    - `password`
    - `roles` (conforme definido no enum Role)
  - Cria a pessoa com os dados fornecidos
  - Responde com os campos `id`, `username` e `role`

**Exemplo de requisição:**

```json
{
  "username": "zerocool",
  "password": "senhasecreta",
  "role": "ADMIN"
}
```

**Exemplo de resposta:**

```json
{
  "id": 1,
  "username": "zerocool",
  "role": "ADMIN"
}
```

</details>

### 2. Adição de Autenticação com Spring Security

<details>
 <summary>📍🌐🔑🛡️ Adição de Autenticação com Spring Security </summary><br />

Configurei o Spring Security para gerenciar a autenticação e autorização na aplicação. Implementei um sistema de login que retorna um token JWT, garantindo sessões seguras para os usuários.

**Configurações e Endpoints:**

1.  **Endpoints Públicos:**

    - POST /persons (para permitir cadastro de novas pessoas)
    - POST /auth/login (para permitir login)

2.  **Rota de Login:**

    - **POST /auth/login**
      - Recebe `username` e `password` no corpo da requisição
      - Valida os dados utilizando os usuários cadastrados
      - Retorna status 403 caso os dados estejam incorretos
      - Retorna um campo `token` contendo um JWT gerado caso os dados estejam corretos

**Exemplo de requisição:**

```json
{
  "username": "zerocool",
  "password": "senhasecreta"
}
```

**Exemplo de resposta:**

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhZ3JpeCIsInN1YiI6Im1ycm9ib3QiLCJleHAiOjE2ODk5ODY2NTN9.lyha4rMcMhFd_ij-farGCXuJy-1Tun1IpJd5Ot6z_5w"
}
```

**Detalhes Técnicos:**

- **Configuração do Spring Security:**
  - Configurei a segurança da aplicação para proteger as rotas sensíveis.
  - Utilizei JWT para gerenciar sessões de usuários, garantindo que apenas usuários autenticados possam acessar determinados recursos.
  - Implementei filtros para interceptar e validar tokens JWT em cada requisição.

</details>

### 3. Limitar Acesso à Rota GET /farms

<details>
	 <summary>📍🌐🛡️ Detalhes da Rota: </summary><br />

Implementei a limitação de acesso à rota GET /farms, permitindo que apenas usuários autenticados com roles USER, MANAGER ou ADMIN possam acessar esta rota.

- Retorna status 403 caso a pessoa não tenha as permissões corretas.
- Retorna a resposta usual caso a pessoa tenha as permissões corretas.

</details>

### 4. Limitar Acesso à Rota GET /crops

<details>
	 <summary>📍🌐🛡️ Detalhes da Rota: </summary><br />

Implementei a limitação de acesso à rota GET /crops, permitindo que apenas usuários autenticados com roles MANAGER ou ADMIN possam acessar esta rota.

- Retorna status 403 caso a pessoa não tenha as permissões corretas.
- Retorna a resposta usual caso a pessoa tenha as permissões corretas.

</details>

### 5. Limitar Acesso à Rota GET /fertilizers

<details>
	 <summary>📍🌐🛡️ Detalhes da Rota: </summary><br />

Implementei a limitação de acesso à rota GET /fertilizers, permitindo que apenas usuários autenticados com role ADMIN possam acessar esta rota.

- Retorna status 403 caso a pessoa não tenha as permissões corretas.
- Retorna a resposta usual caso a pessoa tenha as permissões corretas.

</details>

### Conclusão

Com a conclusão da Fase C, o projeto Agrix está agora mais seguro e robusto, permitindo uma gestão eficiente e segura das informações agrícolas. A implementação de Spring Security e a configuração de autenticação e autorização garantem que apenas usuários autorizados possam acessar as funcionalidades críticas da aplicação. A migração do código da Fase B foi realizada com sucesso, integrando todas as funcionalidades anteriores e permitindo a continuidade do desenvolvimento.

Em todo o projeto até esse ponto, fui capaz de:

- Aplicar o conhecimento do ecossistema Spring para criar rotas da API.
- Aplicar a injeção de dependência para conectar as camadas de controle, serviço e persistência.
- Utilizar o Spring Data JPA para implementar entidades e repositórios para a persistência em banco de dados.
- Implementar gerenciamento de erros no Spring Web.
- Criar o Dockerfile e Docker Compose para configurar a aplicação para execução no Docker.
- Como implementar buscas customizadas.
- Utilizar campos de data nas rotas da API e no banco de dados.
- Criar testes unitários para garantir a qualidade e funcionamento correto da implementação, com cobertura de código adequada.
- Aplicar o conhecimento sobre Spring Security para adicionar autenticação ao projeto.
- Garantir que diferentes rotas atenda a regras específicas de autorização.
