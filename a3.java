import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// 1. CLASSE CLIENTE
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

// 2. SUPERCLASSE ABSTRATA (Aplica reuso de código para Filmes e Jogos)
abstract class ItemLocavel {
    String titulo;
    double precoBase;
    int estoque;

    public ItemLocavel(String titulo, double precoBase, int estoque) {
        this.titulo = titulo;
        this.precoBase = precoBase;
        this.estoque = estoque;
    }

    // Método abstrato que cada mídia implementará à sua maneira
    public abstract void exibirInfo();

    // Método polimórfico unificado para calcular preço e validar estoque
    public boolean alugar(int copias, ClienteVip cliente) {
        if (copias <= estoque) {
            double total = copias * precoBase;
            if (cliente.isVip) {
                total *= 0.8; // Desconto de 20%
                System.out.println("[Desconto VIP Aplicado!]");
            }
            System.out.println("Custo total para " + copias + " cópias: R$ " + total);
            estoque -= copias; // Atualiza o estoque automaticamente após o aluguel
            return true;
        }
        System.out.println("Desculpe, estoque insuficiente (" + estoque + " disponíveis).");
        return false;
    }
}

// 3. CLASSE FILME (Herda de ItemLocavel)
class Filme extends ItemLocavel {
    String diretor;

    public Filme(String titulo, String diretor, double precoBase, int estoque) {
        super(titulo, precoBase, estoque);
        this.diretor = diretor;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Filme: " + titulo + " | Diretor: " + diretor + " | Preço: R$ " + precoBase + " | Estoque: " + estoque);
    }
}

// 4. CLASSE JOGO (Herda de ItemLocavel)
class Jogo extends ItemLocavel {
    String plataforma;

    public Jogo(String titulo, String plataforma, double precoBase, int estoque) {
        super(titulo, precoBase, estoque);
        this.plataforma = plataforma;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Jogo: " + titulo + " | Console: " + plataforma + " | Preço: R$ " + precoBase + " | Estoque: " + estoque);
    }
}

// CLASSE PRINCIPAL TOTALMENTE OTIMIZADA
public class a3 {
    // Map para busca instantânea de usuários (Chave: Email, Valor: Objeto ClienteVip)
    private static final Map<String, String> senhasUsuarios = new HashMap<>();
    private static final Map<String, ClienteVip> perfisUsuarios = new HashMap<>();
    
    // Listas dinâmicas para os catálogos
    private static final List<ItemLocavel> catalogoFilmes = new ArrayList<>();
    private static final List<ItemLocavel> catalogoJogos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        inicializarDados(); // Carrega o banco de dados inicial

        ClienteVip clienteLogado = null;

        // --- SISTEMA DE ACESSO (LOGIN / CADASTRO) ---
        while (clienteLogado == null) {
            System.out.println("\n=== SISTEMA DE BOAS-VINDAS ===");
            System.out.println("1 - Fazer Login");
            System.out.println("2 - Criar Novo Cadastro");
            System.out.println("3 - Sair do Programa");
            System.out.print("Escolha uma opção: ");
            
            int opcao = teclado.nextInt();
            teclado.nextLine(); // Limpa o buffer do scanner

            if (opcao == 3) {
                System.out.println("Programa encerrado.");
                teclado.close();
                return;
            }

            if (opcao == 2) {
                System.out.println("\n--- TELA DE CADASTRO ---");
                System.out.print("Nome completo: ");
                String nome = teclado.nextLine().trim();
                System.out.print("E-mail: ");
                String email = teclado.nextLine().trim();
                System.out.print("Senha: ");
                String senha = teclado.nextLine().trim();
                System.out.print("Deseja plano VIP? (S/N): ");
                boolean vip = teclado.nextLine().trim().equalsIgnoreCase("S");

                if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                    System.out.println("Erro: Campos não podem ser vazios.");
                } else {
                    senhasUsuarios.put(email, senha);
                    perfisUsuarios.put(email, new ClienteVip(nome, "USER-" + (perfisUsuarios.size() + 1), vip));
                    System.out.println("✔ Cadastro realizado com sucesso!");
                }
            } else if (opcao == 1) {
                System.out.println("\n--- TELA DE LOGIN ---");
                System.out.print("Email: ");
                String email = teclado.nextLine().trim();
                System.out.print("Senha: ");
                String senha = teclado.nextLine().trim();

                // Busca O(1): Valida o login instantaneamente sem precisar usar loops 'for'
                if (senhasUsuarios.containsKey(email) && senhasUsuarios.get(email).equals(senha)) {
                    System.out.println("Sucesso: Home");
                    clienteLogado = perfisUsuarios.get(email);
                } else {
                    System.out.println("Erro: Login errado");
                }
            }
        }

        // --- SISTEMA INTERATIVO DA LOCADORA ---
        System.out.println("\n=== BEM-VINDO À LOCADORA ===");
        clienteLogado.exibirCliente();

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n--- MENU DE LOCAÇÃO ---");
            System.out.println("1 - Ver Catálogo de Filmes");
            System.out.println("2 - Ver Catálogo de Jogos");
            System.out.println("3 - Alugar um Item");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcaoLocacao = teclado.nextInt();
            teclado.nextLine();

            switch (opcaoLocacao) {
                case 1:
                    System.out.println("\n--- FILMES DISPONÍVEIS ---");
                    catalogoFilmes.forEach(ItemLocavel::exibirInfo);
                    break;
                case 2:
                    System.out.println("\n--- JOGOS DISPONÍVEIS ---");
                    catalogoJogos.forEach(ItemLocavel::exibirInfo);
                    break;
                case 3:
                    System.out.print("\nO que deseja alugar? (filme/jogo): ");
                    String tipo = teclado.nextLine().trim();
                    System.out.print("Digite o título exato: ");
                    String tituloProcurado = teclado.nextLine().trim();
                    System.out.print("Quantidade de cópias: ");
                    int copias = teclado.nextInt();
                    teclado.nextLine();

                    // Define qual lista buscar com base no tipo informado
                    List<ItemLocavel> listaAlvo = tipo.equalsIgnoreCase("filme") ? catalogoFilmes : catalogoJogos;
                    boolean encontrado = false;

                    // Varre dinamicamente a lista sem precisar criar ifs engessados para cada filme
                    for (ItemLocavel item : listaAlvo) {
                        if (item.titulo.equalsIgnoreCase(tituloProcurado)) {
                            encontrado = item.alugar(copias, clienteLogado);
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Item não disponível ou título incorreto.");
                    }
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        teclado.close();
        System.out.println("\nSistema encerrado. Obrigado!");
    }

    // Método utilitário para alimentar o banco de dados inicial fictício
    private static void inicializarDados() {
        senhasUsuarios.put("teste@teste.com", "1234");
        perfisUsuarios.put("teste@teste.com", new ClienteVip("Usuário Teste", "VIP-001", true));

        catalogoFilmes.add(new Filme("Matrix", "Wachowskis", 25.0, 20));
        catalogoFilmes.add(new Filme("Interestelar", "Christopher Nolan", 30.0, 10));
        
        catalogoJogos.add(new Jogo("GTA V", "PS5", 40.0, 5));
    }
}