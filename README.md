# Sistema de Notas e Frequência de Alunos

Este sistema foi desenvolvido como parte de um desafio para gerenciar as notas e frequências dos alunos. O projeto utiliza Spring Boot para o backend, com banco de dados MySQL, e React para a interface de usuário.

## Instruções de Execução

Para rodar o sistema corretamente em sua máquina, siga as etapas abaixo:

1. **Criar Banco de Dados:**
   Primeiramente, crie uma tabela MySQL em seu computador com o nome `sala_a`. Isso permitirá que o sistema gerencie corretamente as informações de alunos e suas respectivas notas e frequências.

2. **Clonar o Repositório:**
   Clone este repositório para a sua máquina local.

3. **Configurar as Credenciais de Banco de Dados:**
   Após clonar o repositório, altere o usuário e a senha do banco de dados no arquivo `application.properties` para refletir suas credenciais locais e garantir a conexão com o MySQL.

4. **Rodar o Backend:**
   Com as configurações ajustadas, inicie o backend utilizando o Spring Boot.

5. **Rodar o Frontend:**
   Após o backend estar funcionando, navegue até o diretório do frontend (React) e instale as dependências. Em seguida, execute o React.

6. **Explorar as Telas do Sistema:**
   O sistema possui duas telas principais:
   - **Tela de Tabelas**: Exibe as informações desejadas, como notas e frequências dos alunos.
   - **Tela de Cadastro de Alunos**: Permite o cadastro de novos alunos no sistema.

## Premissas Assumidas

- A utilização de um banco de dados era essencial para armazenar e gerenciar as informações.
  
- O React foi escolhido devido à sua relevância para o cargo disputado e sua popularidade no desenvolvimento frontend.
  
- A integração entre o frontend em React e o backend em Spring Boot foi considerada uma parte essencial do projeto, visando garantir a comunicação eficiente entre a interface do usuário e o banco de dados.
  
- A interface do sistema deveria ser responsiva e compatível com diferentes dispositivos, garantindo uma boa experiência tanto em desktops quanto em dispositivos móveis.
  
- Foi assumido que a persistência dos dados seria realizada apenas com o MySQL, sem necessidade de implementar outras soluções de banco de dados, focando em uma estrutura simples e funcional.


## Decisões de Projeto

- **Spring Boot** foi utilizado no backend por ser uma tecnologia baseada em Java, que é similar ao C# utilizado pela empresa. Além disso, já possuía familiaridade com o framework, o que acelerou o desenvolvimento.
  
- Dediquei mais tempo ao desenvolvimento do **frontend com React**, pois acredito que a estética e a experiência do usuário (UX) são cruciais para o sucesso do projeto.
  
- Criação de um **DTO (Data Transfer Object)** para transmitir as informações dos alunos de forma eficiente e organizada entre o backend e o frontend.
  
- Apesar de imprevistos que reduziram o tempo disponível, mantive um bom nível de organização para entregar o projeto dentro do prazo.

## Desafios e Aprendizados

Este projeto foi especialmente interessante para mim devido ao meu **desconforto com o frontend**. React era uma tecnologia que eu ainda estava aprendendo, e este desafio me forçou a sair da minha zona de conforto. Foi uma experiência rica, onde precisei aprender novas abordagens e resolver problemas inesperados.

Além disso, o desenvolvimento com o React foi uma ótima oportunidade para aprimorar minhas habilidades em criar interfaces mais atraentes e funcionais, refletindo o valor de uma boa **usabilidade** em sistemas complexos.
