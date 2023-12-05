# 📑🖋️ Gerenciador de Tarefas
Neste projeto foi desenvolvido uma API REST em Java utilizando o Spring e aplicando os conceitos como camada de serviço e de controle, DTOs, record e as anotações para mapeamento de rotas.
Essa aplicação funciona como um gerenciador de tarefas (*To Do List*). 

A partir dos endpoints criados, é possível adicionar e remover uma tarefa nova, marcar uma tarefa como concluída, listar uma única tarefa ou todas as tarefas.

## ⚙️ Instalação das dependências
Para instalar as dependências do projeto, execute o comando `mvn install`. 
Isso fará o download das dependências configuradas no `pom.xml`, além de baixar as dependências indiretas.

## ✅ Funcionalidades Implementadas
### (1) Endpoint GET `/tasks` para retornar todas as tarefas

### (2) Endpoint GET `/tasks/{id}` para retornar a tarefa com determinado id

### (3) Endpoint POST `/tasks` para criar uma nova tarefa

### (4) Endpoint PUT `/tasks/{id}` para alterar o status da tarefa para 'Concluída'

### (5) Endpoint DELETE `/tasks/{id}` para a remoção de tarefas

## 🧹 Linter (Checkstyle)
O Checkstyle é usado para fazer a análise estática do código. Este projeto já vem com as dependências relacionadas ao linter configuradas no arquivo `pom.xml`. Caso deseje rodar o Checkstyle manualmente, basta executar o comando `mvn checkstyle:check`.

## ℹ️ Considerações finais
Este projeto é apenas para fins educacionais. Qualquer dúvida ou sugestão, sinta-se à vontade para entrar em contato.
