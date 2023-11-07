# Flyway
## O que é?
Flyway é uma dentre as várias ferramentas que se propõem a trazer ordem e organização para os scripts SQL que são executados no banco de dados, funcionando como um controle de versão do mesmo.
## Quais problemas ele se propõe a sanar?
Uma ferramenta como esta permite:
1. Sincronizar o banco de dados com a versão da aplicação;
2. Saber quais scripts SQL foram executados ou não;
3. Automatizar a execução dos scripts;
4. Criar um banco de dados do zero;
5. Permite criar um rollback de mudanças no banco de dados (útil em casos raros).

## Quando usá-lo?

Creio que é uma opção válida para projetos de qualquer tamanho. Como elas costumam ser ferramentas de fácil configuração e uso, não vejo muitos motivos para abrir mão dela, pois ela traz consigo várias vantagens.

Ela pode ser dispensável em alguns projetos onde existam DBAs envolvidos e estes preferem controlar os scripts SQL aplicados fora da aplicação.

## Anotações

1. @RestControllerAdvice: anotação que indica que a classe é um controlador de exceções.