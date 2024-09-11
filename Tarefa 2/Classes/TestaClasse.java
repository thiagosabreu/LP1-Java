import java.util.Scanner;

public class TestaClasse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Cachorro cachorro = new Cachorro("Rex", "Labrador", 30.5, 5);
        Flores flor = new Flores("Rosa", "Vermelha", "Perene");
        JogadorasDeVolei jogadora = new JogadorasDeVolei("Ana", "Oposta", 1.85, 7, 25);
        KpopSingers kpopSinger = new KpopSingers("Jin", 28, "BTS", "Preto", 1.78);
        Planetas planeta = new Planetas("Terra", 1.0, 12742, 149.6, false);
        Refrigerante refrigerante = new Refrigerante("Coca-Cola", "Cola", "Coca-Cola Company", 350, false);
        Salgadinhos salgadinho = new Salgadinhos("Doritos", "Queijo Nacho", 120.0, 10);
        Salgadinhos salgadinho2 = new Salgadinhos("Ruffles", "Original", 100.0, 7);
        Sanrio sanrio = new Sanrio("Hello Kitty", "Maçã", "Rosa", 10);
        TiposDeCabelo cabelo = new TiposDeCabelo("Ondulado", "Castanho", 30.0, true);
        TrabalhadoresDeEscritorio trabalhador = new TrabalhadoresDeEscritorio("Carlos", "Gerente", 8500.0, 40);

        int opcao = 0;

        while (opcao != 11) {
            System.out.println("===== MENU DE TESTES =====");
            System.out.println("1. Testar Cachorro");
            System.out.println("2. Testar Flores");
            System.out.println("3. Testar Jogadoras de Vôlei");
            System.out.println("4. Testar Kpop Singers");
            System.out.println("5. Testar Planetas");
            System.out.println("6. Testar Refrigerante");
            System.out.println("7. Testar Salgadinhos");
            System.out.println("8. Testar Sanrio");
            System.out.println("9. Testar Tipos de Cabelo");
            System.out.println("10. Testar Trabalhadores de Escritório");
            System.out.println("11. Sair");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
            } else {
                System.out.println("Entrada inválida. Por favor, insira um número entre 1 e 11.");
                scanner.next();
                continue;
            }

            System.out.println();

            switch (opcao) {
                case 1:
                    System.out.println("--- Detalhes do Cachorro ---");
                    System.out.println("Nome: " + cachorro.getNome());
                    System.out.println("Raça: " + cachorro.getRaca());
                    System.out.println("Peso: " + cachorro.getPeso() + " kg");
                    System.out.println("Idade: " + cachorro.getIdade() + " anos");
                    cachorro.Latir();
                    cachorro.Correr();
                    System.out.println();
                    break;

                case 2:
                    System.out.println("--- Detalhes da Flor ---");
                    System.out.println("Nome: " + flor.getNome());
                    System.out.println("Cor: " + flor.getCor());
                    System.out.println("Tipo: " + flor.getTipo());
                    flor.Florescer();
                    flor.Murchar();
                    System.out.println();
                    break;

                case 3:
                    System.out.println("--- Detalhes da Jogadora de Vôlei ---");
                    System.out.println("Nome: " + jogadora.getNome());
                    System.out.println("Posição: " + jogadora.getPosicao());
                    System.out.println("Altura: " + jogadora.getAltura() + " m");
                    System.out.println("Número da Camisa: " + jogadora.getNumeroCamisa());
                    System.out.println("Idade: " + jogadora.getIdade() + " anos");
                    jogadora.Sacar();
                    jogadora.Atacar();
                    System.out.println();
                    break;

                case 4:
                    System.out.println("--- Detalhes do Kpop Singer ---");
                    System.out.println("Nome: " + kpopSinger.getNome());
                    System.out.println("Idade: " + kpopSinger.getIdade() + " anos");
                    System.out.println("Grupo: " + kpopSinger.getGrupo());
                    System.out.println("Cor do Cabelo: " + kpopSinger.getCorCabelo());
                    System.out.println("Altura: " + kpopSinger.getAltura() + " m");
                    kpopSinger.Cantar();
                    kpopSinger.Dancar();
                    System.out.println();
                    break;

                case 5:
                    System.out.println("--- Detalhes do Planeta ---");
                    System.out.println("Nome: " + planeta.getNome());
                    System.out.println("Massa: " + planeta.getMassa() + " vezes a massa da Terra");
                    System.out.println("Diâmetro: " + planeta.getDiametro() + " km");
                    System.out.println("Distância do Sol: " + planeta.getDistanciaDoSol() + " milhões de km");
                    System.out.println("Possui Anéis: " + (planeta.isTemAnel() ? "Sim" : "Não"));
                    planeta.orbitar();
                    planeta.girar();
                    System.out.println();
                    break;

                case 6:
                    System.out.println("--- Detalhes do Refrigerante ---");
                    System.out.println("Nome: " + refrigerante.getNome());
                    System.out.println("Sabor: " + refrigerante.getSabor());
                    System.out.println("Marca: " + refrigerante.getMarca());
                    System.out.println("Volume: " + refrigerante.getVolumeML() + " ml");
                    System.out.println("É Diet: " + (refrigerante.isDiet() ? "Sim" : "Não"));
                    refrigerante.abrir();
                    refrigerante.servir();
                    System.out.println();
                    break;

                case 7:
                    System.out.println("--- Detalhes do Salgadinho ---");
                    System.out.println("Nome: " + salgadinho.getNome());
                    System.out.println("Sabor: " + salgadinho.getSabor());
                    System.out.println("Peso: " + salgadinho.getPeso() + " g");
                    salgadinho.Comer();
                    salgadinho.compararPeso(salgadinho2);
                    System.out.println();
                    break;

                case 8:
                    System.out.println("--- Detalhes do Personagem Sanrio ---");
                    System.out.println("Nome: " + sanrio.getNome());
                    System.out.println("Comida Favorita: " + sanrio.getComidaFav());
                    System.out.println("Cor: " + sanrio.getCor());
                    System.out.println("Idade: " + sanrio.getIdade() + " anos");
                    sanrio.Brincar();
                    sanrio.Cozinhar();
                    System.out.println();
                    break;

                case 9:
                    System.out.println("--- Detalhes do Tipo de Cabelo ---");
                    System.out.println("Tipo: " + cabelo.getTipo());
                    System.out.println("Cor: " + cabelo.getCor());
                    System.out.println("Comprimento: " + cabelo.getComprimento() + " cm");
                    System.out.println("É Natural: " + (cabelo.isNatural() ? "Sim" : "Não"));
                    cabelo.cortar(5.0);
                    System.out.println("Comprimento após corte: " + cabelo.getComprimento() + " cm");
                    cabelo.tingir("Loiro");
                    System.out.println("Cor após tingimento: " + cabelo.getCor());
                    System.out.println("É Natural após tingimento: " + (cabelo.isNatural() ? "Sim" : "Não"));
                    System.out.println();
                    break;

                case 10:
                    System.out.println("--- Detalhes do Trabalhador de Escritório ---");
                    System.out.println("Nome: " + trabalhador.getNome());
                    System.out.println("Cargo: " + trabalhador.getCargo());
                    System.out.println("Salário: R$ " + trabalhador.getSalario());
                    System.out.println("Idade: " + trabalhador.getIdade() + " anos");
                    trabalhador.Trabalhar();
                    trabalhador.ParticiparDeReuniao();
                    System.out.println();
                    break;

                case 11:
                    System.out.println("Encerrando o programa. Até mais!");
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção entre 1 e 11.\n");
                    break;
            }
        }

        scanner.close();
    }
}
