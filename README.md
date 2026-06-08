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


<h2>Codigo:</h2>

     class Filme{
         String title;
         String producer;
         double cost;
         int noOfFilme;

     public Filme (String title, String producer, double cost, int noOFilme){
        this.title = title;
        this.producer = producer;
        this.cost = cost;
        this.noOfFilme = noOfFilme;
    }

    public void displayFilmeInfo(){
        System.out.println("Titulo: " + title);
        System.out.println("Autor: " + producer);
        System.out.println("Preço: " + cost);
        System.out.println("Filmes Disponiveis: " + noOfFilme);
    }

    public boolean checkDispCost(int requestedCopies){
        if(requestedCopies <= noOfFilme){
            double totalCost = requestedCopies * cost;
            System.out.println("Custo total para" + requestedCopies + "copias" totalCost);
            return true;
        }else{
            System.out,println("Descupe, Filme já alugado");
            return false;
             }
         }
     }
<h3>Aqui temos um exemplo de poo, a onde criamos a classe dos filmes a onde damos seus "atributos", sendo eles Titulo, autor, preço e se ele esta disponivel ou não</h3>

--------------------------------------------------

     ublic class rental_company{
    public static void main(String[] args) {
        Movie movie1 = new Movie ("exemplo de filme 1"," exemplo de diretor 1", 25, 20 );
        Movie movie2 = new Movie ("exemplo de filme 2"," exemplo de diretor 2", 25, 20);
        Movie movie3 = new Movie ("exemplo de filme 3"," exemplo de diretor 3", 25, 20);

        System.out.println("Detalhes do filme 1");
        movie1.displayFilmeInfo();
        System.out.println("Detalhes do filme 2");
        movie2.displayFilmeInfo();
        System.out.println("Detalhes do filme 3");
        movie3.displayFilmeInfo();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número do filme que você deseja: ");
        String requestTitle = scanner.nextLine();
        System.out.println("Digite o tempo de locação que voçê deseja: ");
        int requestedCopies = scanner.nextInt();

        boolean movieFound = false;
        if(requestedTitle.equalsIgnoreCase(movie1.title)){
            movieFound = movie1.checkDispCost(requestedCopies);
        }else if(requestedTitle.equalsIgnoreCase(movie2.title)){
            movieFound = movie2.checkDispCost(requestedCopies);
        }else if(requestedTitle.equalsIgnoreCase(movie3.title)){
            movieFound = movie3.checkDispCost(requestedCopies);
        }
        
        if(!movieFound){
            System.out.println("Filme não encontrado");
        }
        scanner.close();
         }
     }
<h3>Nesta parte do codigo, ira aprensentar a lista de filmes, se tem o filme desejado no catalogo, ou se ele  esta dispinivel ou não.</h3>
     


