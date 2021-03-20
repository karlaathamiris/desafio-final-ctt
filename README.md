# ☕ CRUD Java + MySQL com JDBC + Testes com JUnit
Campinas Tech Talents - Trilha Assertiva

Esse projeto consiste em uma aplicação Java que realiza operações de criar, buscar, atualizar e deletar um usuário em um banco de dados MySQL. Garantindo a funcionalidade dessas operações através de testes unitários com JUnit.

## Ambiente utilizado 
- [Eclipse IDE for Java Developers 2020-12 (4.18.0)](https://www.eclipse.org/downloads/packages/release/2020-12/r/eclipse-ide-java-developers)
- [Versão Java: 11.0.9](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)
- [Versão conector JDBC MySQL: 8.0.23](https://dev.mysql.com/downloads/connector/j/?os=26)
- [Versão MySQL: 8.0.23](https://dev.mysql.com/downloads/installer/)
- [Versão JUnit 4.13.2](https://search.maven.org/artifact/junit/junit/4.13.2/jar)


## Configurações Iniciais:
1. Clone o repositório utilizando o Git: `git clone https://github.com/karlaathamiris/desafio-final-ctt.git`
2. Importe o repositório para o Eclipse:
    1. Com o Eclipse aberto clique no menu *File* 
    2. Em seguida selecione *Open Projects from File System*
    3. Clique em *Directory*  
    4. Busque e selecione o diretório/pasta clonado: `desafio-final-ctt`
    5. Por último clique em *Finish*
3. Importe o JUnit 4 e o conector do MySQL para o Build Path:
    1. Clique com botão direito sobre o projeto desafio-final-ctt na aba *Package Explorer*
    2. Vá até *Properties*
    3. Clique em *Java Build Path*, na aba *Libraries*
        - Para o JUnit:
            1. Clique em *Classpath*, em seguida *Add Library*
            2. Selecione JUnit e avance clicando *Next*
            3. Na opção *JUnit Library Version* selecione JUnit 4
            4. Por fim, clique em *Finish*
        - Para o Conector JDBC MySQL:
            1. Clique em *Add External JARs...*
            2. Selecione o arquivo `mysql-connector-java-8.0.23.jar`
    8. Ao fim, clique em *Apply and Close*

4. É necessário definir a base de dados e a tabela no seu banco de dados. Para isso, execute o seguinte script sql:
```sql
create database <NOME DA BASE DE DADOS>;
use <NOME DA BASE DE DADOS>;
create table if not exists usuarios_ctt (
    id int auto_increment,
    login varchar(255) not null,
    nome varchar(255) not null,
    senha varchar(63) not null,
    data_cadastro date not null,
    primary key(id)
);
```
5. Na classe `ConnectionMySQL.java` é necessário dentro do método `createConnectionMySQL()` adequar a url de conexão de acordo com sua configuração do MySQL. Por exemplo:
```java
Connection conexao = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:<PORTA MYSQL>/<NOME DA BASE DE DADOS>", "<USERNAME MYSQL>", "<SENHA MYSQL>");
```
> Se atente aos seguintes parâmetros:
> - \<PORTA MYSQL\>: Corresponde à porta de conexão com o MySQL, definida durante sua instalação. Normalmente corresponde à porta 3306.
> - \<NOME DA BASE DE DADOS\>: Representa o nome da base definido no script sql utilizado anteriormente.
> - \<USERNAME MYSQL\>: Nome de usuário da conexão com o banco MySQL, definido durante sua instalação. Normalmente corresponde à "root".
> - \<SENHA MYSQL\>: Senha de conexão com o banco MySQL, definida durante a instalação.

## Executando o Projeto:
1. Na classe`Main.java` clique em *Run* ou CTRL + F11 para iniciar o programa.
2. Em seguida no console do Eclipse será exibido o menu para a manipulação dos dados com as seguintes opções:
    1. Cadastrar: cadastra um usuário solicitando as informações de login, nome e senha.
    2. Buscar: exibe o id, login, nome e data de cadastro de todos os usuários cadastrados no banco de dados.
    3. Alterar: solicita inicialmente o login do usuário a ser alterado, e em seguida o novo nome e a nova senha.
    4. Excluir: recebe o login do usuário e deleta todo o cadastro do usuário correspondente.
    5. SAIR DO PROGRAMA: Encerra o programa.

## Efetuando os Testes:
1. Com a classe `TestesDesafioCTT.java` aberta no Eclipse selecione o menu *Run* e em seguida *Run As* e execute como *JUnit Test*.
2. Essa classe irá testar se são válidos:
    1. A conexão com o banco de dados
    2. Cadastrar um usuário
    3. Buscar os usuários
    4. Alterar um usuário
    5. Deletar um usuário