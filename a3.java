import java.util.Scanner;

// 1. CLASSE CLIENTE VIP
class ClienteVip {
    String nome;
    String idCliente;
    boolean isVip;

    public ClienteVip(String nome, String idCliente, boolean isVip) {
        this.nome = nome;
        this.idCliente = idCliente;
        this.isVip = isVip;
    }

    public void exibirCliente() {
        System.out.println("Cliente Logado: " + nome + " | Status VIP: " + (isVip ? "Sim" : "Não"));
    }
}

// 2. CLASSE FILME
class Filme {
    String title;
    String producer;
    double cost;
    int noOfFilme;

    public Filme(String title, String producer, double cost, int noOfFilme) {
        this.title = title;
        this.producer = producer;
        this.cost = cost;
        this.noOfFilme = noOfFilme;
    }

    public void displayFilmeInfo() {
        System.out.println("Título do Filme: " + title);
        System.out.println("Autor/Diretor: " + producer);
        System.out.println("Preço do Filme: R$ " + cost);
        System.out.println("Filmes Disponíveis: " + noOfFilme);
    }

    public boolean checkDispCost(int requestedCopies, ClienteVip cliente) {
        if (requestedCopies <= noOfFilme) {
            double totalCost = requestedCopies * cost;
            
            if (cliente.isVip == true) {
                totalCost = totalCost * 0.8; // 20% de desconto
                System.out.println("[Desconto VIP Aplicado!]");
            }
            
            System.out.println("Custo total para " + requestedCopies + " cópias: R$ " + totalCost);
            noOfFilme = noOfFilme - requestedCopies; // Atualiza o estoque
            return true;
        } else {
            System.out.println("Desculpe, Filme com estoque insuficiente.");
            return false;
        }
    }
}

// 3. CLASSE ALUGUEL DE JOGOS
class Jogo {
    String titulo;
    String plataforma;
    double precoAluguel;
    int estoque;

    public Jogo(String titulo, String plataforma, double precoAluguel, int estoque) {
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.precoAluguel = precoAluguel;
        this.estoque = estoque;
    }

    public void exibirJogoInfo() {
        System.out.println("Título do Jogo: " + titulo);
        System.out.println("Plataforma: " + plataforma);
        System.out.println("Preço do Jogo: R$ " + precoAluguel);
        System.out.println("Jogos Disponíveis: " + estoque);
    }

    public boolean checkDispCostJogo(int copiasDesejadas, ClienteVip cliente) {
        if (copiasDesejadas <= estoque) {
            double custoTotal = copiasDesejadas * precoAluguel;
            
            if (cliente.isVip == true) {
                custoTotal = custoTotal * 0.8; // 20% de desconto
                System.out.println("[Desconto VIP Aplicado!]");
            }
            
            System.out.println("Custo total para " + copiasDesejadas + " cópias do jogo: R$ " + custoTotal);
            estoque = estoque - copiasDesejadas; // Atualiza o estoque
            return true;
        } else {
            System.out.println("Desculpe, Jogo com estoque insuficiente.");
            return false;
        }
    }
}

// CLASSE PRINCIPAL 
public class a3 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // CONTA 1: Cadastro Padrão do sistema (Quem já tem cadastro)
        String emailCadastrado1 = "teste@teste.com";
        String senhaCadastrada1 = "1234";
        String nomeCadastrado1 = "Usuário Teste";
        boolean vipCadastrado1 = true;

        // CONTA 2: Variáveis vazias preparadas para receber um novo cadastro
        String emailCadastrado2 = "";
        String senhaCadastrada2 = "";
        String nomeCadastrado2 = "";
        boolean vipCadastrado2 = false;
        boolean temSegundoUsuario = false; // Controla se alguém se cadastrou

        System.out.println(" === BOAS-VINDAS === ");
        System.out.println("1 - Fazer Login (Para quem já tem cadastro)");
        System.out.println("2 - Criar Novo Cadastro (Para quem é novo)");
        System.out.print("Escolha uma opção: ");
        int opcaoMenu = teclado.nextInt();
        teclado.nextLine(); // Limpa o buffer do teclado

        // --- TELA DE CADASTRO ---
        if (opcaoMenu == 2) {
            System.out.println("\n--- TELA DE CADASTRO --- ");
            System.out.print(" Digite seu nome completo: ");
            nomeCadastrado2 = teclado.nextLine();

            System.out.print(" Digite seu novo e-mail: ");
            emailCadastrado2 = teclado.nextLine();

            System.out.print(" Digite sua nova senha: ");
            senhaCadastrada2 = teclado.nextLine();

            System.out.print(" Você deseja ser um Cliente VIP? (S/N): ");
            String respostaVip = teclado.nextLine();
            
            if (respostaVip.equalsIgnoreCase("S")) {
                vipCadastrado2 = true;
            } else {
                vipCadastrado2 = false;
            }

            // Validação simples de campos vazios
            if (emailCadastrado2.isEmpty() || senhaCadastrada2.isEmpty() || nomeCadastrado2.isEmpty()) {
                System.out.println(" Erro: Os campos de cadastro não podem ser vazios.");
                teclado.close();
                return;
            }

            temSegundoUsuario = true; // Ativa a existência da segunda conta
            System.out.println("\n✔ Cadastro realizado com sucesso! Prossiga para o login.");
        }

        // --- TELA DE LOGIN UNIFICADA ---
        System.out.println("\n--- TELA DE LOGIN --- ");
        System.out.print("Digite seu email: ");
        String emailDigitado = teclado.nextLine();

        System.out.print("Digite sua senha: ");
        String senhaDigitada = teclado.nextLine();

        if (emailDigitado.isEmpty() || senhaDigitada.isEmpty()) {
            System.out.println("Email ou senha não podem ser vazios.");
            teclado.close();
            return;
        }

        ClienteVip clienteLogado = null;
        boolean loginSucesso = false;

        // Validação usando ifs encadeados
        if (emailDigitado.equals(emailCadastrado1) && senhaDigitada.equals(senhaCadastrada1)) {
            System.out.println("Sucesso: Home");
            clienteLogado = new ClienteVip(nomeCadastrado1, "USER-001", vipCadastrado1);
            loginSucesso = true;
        } 
        else if (temSegundoUsuario == true && emailDigitado.equals(emailCadastrado2) && senhaDigitada.equals(senhaCadastrada2)) {
            System.out.println("Sucesso: Home");
            clienteLogado = new ClienteVip(nomeCadastrado2, "USER-002", vipCadastrado2);
            loginSucesso = true;
        }

        // Se nenhum dos ifs acima for verdadeiro
        if (loginSucesso == false) {
            System.out.println("Erro: Login errado");
            System.out.println("--------------------");
            System.out.println("email digitado: " + emailDigitado);
            System.out.println("senha digitada: " + senhaDigitada);
            teclado.close();
            return;
        }

        System.out.println("--------------------");
        System.out.println("email digitado: " + emailDigitado);
        System.out.println("senha digitada: " + senhaDigitada);
        System.out.println("--------------------\n");

        // --- SISTEMA DE LOCADORA ---
        System.out.println("=== BEM-VINDO À LOCADORA ===");
        clienteLogado.exibirCliente();
        System.out.println("============================\n");

        // Catálogo de Filmes
        Filme filme1 = new Filme("Matrix", "Wachowskis", 25.0, 20);
        Filme filme2 = new Filme("Interestelar", "Christopher Nolan", 30.0, 10);
        Jogo jogo1 = new Jogo("GTA V", "PS5", 40.0, 5);

        System.out.println("--- Catálogo de Filmes ---");
        filme1.displayFilmeInfo();
        System.out.println();
        filme2.displayFilmeInfo();
        
        System.out.println("\n--- Catálogo de Jogos ---");
        jogo1.exibirJogoInfo();

        System.out.println("\nO que você deseja alugar? (Digite: filme ou jogo): ");
        String tipoItem = teclado.nextLine();

        boolean itemEncontrado = false;

        // Estrutura de busca utilizando ifs
        if (tipoItem.equalsIgnoreCase("filme")) {
            System.out.println("Digite o título do filme: ");
            String requestTitle = teclado.nextLine();

            System.out.println("Digite a quantidade de cópias: ");
            int requestedCopies = teclado.nextInt();

            if (requestTitle.equalsIgnoreCase(filme1.title)) {
                itemEncontrado = filme1.checkDispCost(requestedCopies, clienteLogado);
            } else if (requestTitle.equalsIgnoreCase(filme2.title)) {
                itemEncontrado = filme2.checkDispCost(requestedCopies, clienteLogado);
            }

            if (itemEncontrado == false) {
                System.out.println("Filme não encontrado.");
            }

        } else if (tipoItem.equalsIgnoreCase("jogo")) {
            System.out.println("Digite o título do jogo: ");
            String requestTitle = teclado.nextLine();

            System.out.println("Digite a quantidade de cópias: ");
            int requestedCopies = teclado.nextInt();

            if (requestTitle.equalsIgnoreCase(jogo1.titulo)) {
                itemEncontrado = jogo1.checkDispCostJogo(requestedCopies, clienteLogado);
            }

            if (itemEncontrado == false) {
                System.out.println("Jogo não encontrado.");
            }
            
        } else {
            System.out.println("Opção inválida de mídia.");
        }

        teclado.close();
        System.out.println("\nSistema encerrado.");
    }
}
