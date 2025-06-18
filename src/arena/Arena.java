package arena;

import arena.entity.Guerreiro;
import arena.entity.Mago;
import arena.entity.Personagem;

import java.util.Scanner;

public class Arena {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //representação dos objetos sendo instanciados
        Guerreiro guerreiro = new Guerreiro("Darius", 120, 18, 5);
        Mago mago = new Mago("Veigar", 90, 8, 20);

        System.out.println("--- PREPARAÇÃO PARA A BATALHA ---");
        exibirInformacoesIniciais(guerreiro);
        exibirInformacoesIniciais(mago);

        System.out.println("\n-------------------");
        System.out.println("A BATALHA COMEÇA!");
        System.out.println("-------------------\n");

        int turno = 1;
        while (guerreiro.estaVivo() && mago.estaVivo()) {
            System.out.printf("--- TURNO %d ---\n", turno);
            exibirStatus(guerreiro, mago);

            Personagem atacante, defensor;

            if (turno % 2 != 0) {
                atacante = guerreiro;
                defensor = mago;
                System.out.println(">> Turno de " + atacante.getNome() + " (Guerreiro)");
                System.out.println("Escolha o ataque: \n 1 - Ataque Brutal \n 2 - Golpe Rápido");
            } else {
                atacante = mago;
                defensor = guerreiro;
                System.out.println(">> Turno de " + atacante.getNome() + " (Mago)");
                System.out.println("Escolha o ataque: \n 1 - Bola de Fogo \n 2 - Raio Arcano");
            }

            System.out.print("Sua escolha: ");
            int escolha = sc.nextInt();

            double danoCausado = atacante.atacar(escolha);
            defensor.receberDano(danoCausado);

            System.out.printf("%s causou %.2f de dano em %s.\n", atacante.getNome(), danoCausado, defensor.getNome());
            System.out.println("-------------------\n");

            turno++;
        }

        System.out.println("--- FIM DA BATALHA ---");
        exibirStatus(guerreiro, mago);
        if (guerreiro.estaVivo()) {
            System.out.println("O vencedor é o Guerreiro " + guerreiro.getNome() + "!");
        } else {
            System.out.println("O vencedor é o Mago " + mago.getNome() + "!");
        }

        sc.close();
    }

    public static void exibirInformacoesIniciais(Personagem p) {
        System.out.println("\n--------------Personagem Criado--------------");
        System.out.println("Nome: " + p.getNome());
        System.out.println("Classe: " + p.getClass().getSimpleName());
        System.out.printf("Vida: %.0f\n", p.getPontosDeVida());
        System.out.println("Força: " + p.getForca());
        System.out.println("Inteligência: " + p.getInteligencia());
    }

    public static void exibirStatus(Personagem p1, Personagem p2) {
        System.out.printf("Status: %s (Vida: %.2f) vs %s (Vida: %.2f)\n",
                p1.getNome(), p1.getPontosDeVida(),
                p2.getNome(), p2.getPontosDeVida());
    }
}