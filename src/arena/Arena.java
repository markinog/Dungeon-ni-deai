package arena;

import arena.entity.D20;
import arena.entity.Guerreiro;
import arena.entity.Mago;
import arena.entity.Personagem;
import arena.utils.Utils;

import java.util.Scanner;

public class Arena {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //representação dos objetos sendo instanciados
        Guerreiro guerreiro = new Guerreiro("Darius", 120, 18, 5);
        Mago mago = new Mago("Veigar", 90, 8, 20);

        System.out.println("--- PREPARAÇÃO PARA A BATALHA ---");
        System.out.println(guerreiro);
        System.out.println(mago);

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
                System.out.println(">> Turno de " + atacante.getNome() + " (Guerreiro)\n");

                atacante.exibirAtaques();
            } else {
                atacante = mago;
                defensor = guerreiro;
                System.out.println(">> Turno de " + atacante.getNome() + " (Mago)\n");

                atacante.exibirAtaques();
            }

            System.out.print("Sua escolha: ");
            int escolha = sc.nextInt();

            int resultado = rolarD20();

            double danoCausado = atacante.atacar(escolha, resultado);
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

    private static int rolarD20() {
        System.out.println("\nRolando um D20...");
        Utils.pause(400);
        int resultado = D20.rolar();
        System.out.printf("Resultado: %d\n\n", resultado);

        return resultado;
    }

    public static void exibirStatus(Personagem p1, Personagem p2) {
        System.out.println("-------------- STATUS --------------");
        System.out.printf("%s (Vida: %.2f) (Fúria: %d)\n", p1.getNome(), p1.getPontosDeVida(), p1.getModificador());
        System.out.printf("%s (Vida: %.2f) (Mana: %d)\n", p2.getNome(), p2.getPontosDeVida(), p2.getModificador());
    }
}