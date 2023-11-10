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

## Como funciona
Sempre que voce quiser fazer uma mudança no banco de dados, voce deve criar um script SQL e colocá-lo na pasta de scripts do Flyway. O Flyway irá executar todos os scripts que ainda não foram executados no banco de dados.

É importante que os scripts tenham nomes que sigam um padrão, pois o Flyway irá executá-los na ordem alfabética. O padrão de nomes é o seguinte:

```
V<versão>__<nome>.sql
```

Quando uma versão é executada, o Flyway armazena o nome do script no banco de dados, para que ele não seja executado novamente.

# JpaRepository
É uma interface que possui vários métodos para manipulação de dados no banco de dados. Ela é uma interface genérica, que recebe dois parâmetros: o tipo da entidade e o tipo do ID da entidade.

Ele é capaz de criar metodos de consulta automaticamente, desde que o nome do método siga um padrão. Por exemplo, se voce quiser buscar um usuário pelo nome, basta criar um método com o nome findByNome, que o Spring irá criar o método de consulta automaticamente.

Outros padrões de nomes de métodos podem ser encontrados na documentação do Spring Data JPA.

# Spring Security
Serve para controlar o acesso aos recursos da aplicação. Ele possui uma configuração padrão, que bloqueia todos os recursos da aplicação. Para liberar o acesso a um recurso, é necessário criar uma classe que herde de WebSecurityConfigurerAdapter e sobrescrever o método configure(HttpSecurity http).

# JWT
É um padrão de token que permite que o usuário seja autenticado sem que seja necessário armazenar o estado dele no servidor. O token é um JSON que possui três partes: header, payload e signature. O header possui o tipo do token e o algoritmo de criptografia. O payload possui os dados do usuário. A signature é a assinatura do token, que é gerada com base no header, payload e uma chave secreta.

Para ultilizar o JWT, é necessário adicionar a dependência do jjwt no pom.xml. É necessário criar uma classe que herde de WebSecurityConfigurerAdapter e sobrescrever o método configure(HttpSecurity http). É necessário criar uma classe que herde de OncePerRequestFilter e sobrescrever o método doFilterInternal. É necessário criar uma classe que implemente UserDetailsService e sobrescrever o método loadUserByUsername. É necessário criar uma classe que implemente AuthenticationProvider e sobrescrever o método authenticate.

## Metodos
1. generateToken: método que gera o token.
2. getAuthentication: método que obtém o usuário autenticado com base no token.
3. isTokenValid: método que verifica se o token é válido.
4. getUsername: método que obtém o nome do usuário com base no token.
5. getAuthorities: método que obtém as autorizações do usuário com base no token.
6. resolveToken: método que obtém o token da requisição.
7. doFilterInternal: método que filtra as requisições.
8. doFilter: método que filtra as requisições.
9. addAuthentication: método que adiciona o token na resposta da requisição.
10. getAuthenticationManager: método que obtém o gerenciador de autenticação.
11. configure: método que configura o gerenciador de autenticação.

## Anotações

### AuthenticationManager
É uma interface que possui um método chamado authenticate, que recebe um objeto do tipo Authentication e retorna um objeto do tipo Authentication. O AuthenticationManager é responsável por autenticar o usuário.

### Algorithm
É uma classe que possui vários métodos estáticos para criptografar e descriptografar dados. Ela possui vários algoritmos de criptografia, como MD5, SHA-256, etc.

### BCryptPasswordEncoder
É uma classe que possui um método chamado encode, que recebe uma String e retorna uma String. O método é responsável por criptografar a String recebida.

## Anotações

1. @RestControllerAdvice: anotação que indica que a classe é um controlador de exceções.
2. @RequiredArgsConstructor(onConstructor = @__(@Autowired)): anotação que indica que o construtor da classe deve receber um parâmetro do tipo especificado. O parâmetro deve ser anotado com @NonNull. O parâmetro deve ser final. Autowired é a anotação que indica que o parâmetro deve ser injetado.
3. @RequestBody: anotação que indica que o parâmetro do método deve ser obtido do corpo da requisição.
4. @Valid: anotação que indica que o parâmetro do método deve ser validado. A validação é feita com base nas anotações colocadas na classe do parâmetro.
5. @Transactional: anotação que indica que o método deve ser executado dentro de uma transação. Se o método lançar uma exceção, a transação será desfeita.
6. @PathVariable: anotação que indica que o parâmetro do método deve ser obtido da URL da requisição. O nome do parâmetro deve ser igual ao nome do parâmetro da URL.