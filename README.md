<h1> Rental Company </h1>
<h3> Empresa de locação de filmes e jogos de tabuleiro, o sistema visa uma maior automação da loja </h3>

<h2>Sobre o projeto: </h2>
<h3>O projeto ao qual trabalhamos é chamado de Rental Company, como o nome sugere é uma plataforma que possibilita alugar filmes, com um bonus de ser rapido e barato
e com prazos justos, o que possibilita um bom aproveitamento de seu aluguel e do filme alugado, isso constroi confiança entre a Rental Company e o usuario
o sistema é utilizado para uma automação maior da loja fisica, a onde a pessoa pode ver oque esta alugado e o que esta disponivel, alem de ter filmes, possuimos jogos de tabuleiro.
</h3>

<h2>Desenvolvedores:</h2>

+ Gabriel Alencar Do Nascimento
+ Luan Calixto Barbosa
+ Natanael do Nascimento Souza
+ Nycolas Arruda de Lima
+ Matheus Abrão Czopko

<h2>Principais Funcionalidades: </h2>
<h3> O programa foi feito utilizando a linguaguem de programação Java, no qual utilizamos de POO (Programação orientada a objeto), utilizando de classes, objetos, atributos e métodos
     , encapsulamento, herança, cadastro, listagem e consulta de dados.
</h3>

+ Cadastro e autenticação
+ Locação de filmes
+ Locação de jogos da tabuleiro
+ Observação de disnopibilidade


<h2>Como Utilizar:</h2>
<h3>Para o utilizar o nosso programa é facil, basta fazer seu cadastro/login, apos isso, basta digitar o filme que deseja e o sistema ira dizer se ele esta disponivel ou não.</h3>




<h2>Tecnologias Utilizadas: </h2>
<h3>O programa foi feito utilizando a linguaguem de programação Java, no qual utilizamos de POO (Programação orientada a objeto), utilizando de: </h3

+ Classes
+ Objetos
+ Atributos
+ Métodos
+ Encapsulamento
+ Herança
+ Cadastro
+ Listagem
+ Consulta de dados



<h2>Como Funciona?</h2>
<h3>O código funciona como uma tela de login (validação de acesso). Após o login bem-sucedido, a classe principal (main) fica liberada para gerenciar as outras funcionalidades do sistema, tais como:

Criar objetos de filmes;
Consultar estoque e disponibilidade;
Aplicar 20% de desconto para ClienteVip;
Realizar locações.

Em suma: é o ponto de partida que valida o usuário para liberar o uso do sistema de locação.

--------------------------------------------------------------------------------------------------

O sistema é composto por 4 partes principais que trabalham juntas:1. Classe FilmeÉ a receita que define o que é um filme no sistema.Atributos (Dados): Guarda o título, o diretor/autor, o preço base de locação e a quantidade de cópias disponíveis em estoque.displayFilmeInfo(): Método que imprime na tela todas as informações do filme.checkDispCost(): O motor financeiro do filme. Ele verifica se há estoque suficiente para o pedido. Se houver, calcula o preço total e aplica o desconto se o cliente for VIP.2. Classe JogoSimilar à classe Filme, mas adaptada para o universo dos games.Atributos (Dados): Guarda o título do game, a plataforma (ex: PS5, Xbox), o preço e o estoque.checkDispCostJogo(): Realiza a mesma validação financeira do filme, garantindo que as regras de negócio (estoque e desconto VIP) funcionem perfeitamente para mídias de videogame.3. Classe ClienteVipGerencia as informações de quem está alugando.Atributos (Dados): Guarda o nome do cliente, o ID de identificação e um indicador lógico (true/false) que diz se ele tem direito a benefícios VIP.Regra de Negócio: Se o cliente for VIP, o sistema deduz automaticamente 20% do valor total no momento do cálculo do aluguel.4. Classe rental_company (A Executora)É o cérebro do programa. Contém o método main, que dá a partida no sistema, cria os objetos de teste (filmes, jogos, clientes) e gerencia a interação com o usuário final via teclado.

</h3>



