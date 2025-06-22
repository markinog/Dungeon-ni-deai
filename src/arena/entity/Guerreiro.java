package arena.entity;

import java.util.Random;

public class Guerreiro extends Personagem {

    private int furia;

    public Guerreiro(String nome, int pontosDeVida, int forca, int inteligencia) {
        super(nome, pontosDeVida, forca, inteligencia);
        furia = 0;
    }

    private void aumentarFuria(int modificador) {
        Random ran = new Random();
        int valor = 1 + ran.nextInt((20 - 1) + 1);

        furia += valor;
        furia += modificador;
    }

    //polimorfismo
    //cumpre o contrato da classe pai
    @Override
    public double atacar(int tipoAtaque, int valorDado) {
        boolean critico = valorDado >= 18;
        boolean falha = valorDado <= 4;

        int furiaGanho = 5;

        if (falha) {
            aumentarFuria(15);
            System.out.println(this.nome + " falhou em seu ataque.");

            return 0;
        }

        StringBuilder sb = new StringBuilder();

        double dano = 0;
        switch (tipoAtaque) {
            case 1:
                sb.append(this.nome + " usa Ataque Brutal!");
                dano = (this.forca * 2.0) + (this.pontosDeVida * 0.1);
                break;
            case 2:
                sb.append(this.nome + " usa Golpe Rápido!");
                dano = this.forca * 1.8;
                break;
            case 3:
                if (furia >= 50) {
                    sb.append(this.nome + "usa Golpe do Abismo!");
                    dano = this.forca * 3.5 - (this.pontosDeVida * 0.2);
                    furia -= 50;
                } else {
                    sb.append("Sem fúria o suficiente, utilizando ataque básico");
                    dano = this.forca * 1.5;
                }
                break;
            default:
                sb.append("Opção de ataque inválida! Usando ataque padrão.");
                dano = this.forca * 1.5;
                break;
        }

        if (critico && tipoAtaque != 3) {
            furiaGanho = 10;
            System.out.print(" FOI UM ATAQUE CRITICO!!!");
            dano *= 2;
        }

        sb.append("\n");
        System.out.println(sb);

        aumentarFuria(furiaGanho);

        return dano;
    }

    @Override
    public int getModificador() {
        return furia;
    }

    @Override
    public void exibirAtaques() {
        System.out.println("Escolha o ataque:");
        System.out.println("1 - Ataque Brutal");
        System.out.println("2 - Golpe Rápido");
        System.out.println("3 - Golpe do Abismo (ULTIMATE)");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-------------- Guerreiro Criado --------------\n");
        sb.append(String.format("Nome: %s\n", nome));
        sb.append("Classe: Guerreiro\n");
        sb.append(String.format("Pontos de vida: %.0f\n", pontosDeVida));
        sb.append(String.format("Força: %d\n", forca));
        sb.append(String.format("Inteligência: %d\n",inteligencia));
        sb.append(String.format("Fúria: %d\n",furia));

        return sb.toString();
    }
}