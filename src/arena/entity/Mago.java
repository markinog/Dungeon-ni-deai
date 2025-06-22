package arena.entity;

public class Mago extends Personagem {

    private int mana;
    private final double ataquePadrao = inteligencia * 1.5;

    public Mago(String nome, int pontosDeVida, int forca, int inteligencia) {
        super(nome, pontosDeVida, forca, inteligencia);
        mana = 100;
    }

    private boolean realizarAtaque(int manaNecessaria) {
        if (mana < manaNecessaria) {
            System.out.println("Mana insuficiente. Utilizando ataque padrão.");
            return false;
        }

        mana -= manaNecessaria;

        return true;
    }

    //polimorfismo
    //cumpre o contrato da classe pai
    @Override
    public double atacar(int tipoAtaque, int valorDado) {
        boolean critico = valorDado >= 15;
        boolean falha = valorDado <= 4;

        double dano;
        if (falha) {
            System.out.println(this.nome + " falhou em seu ataque.");
            return 0;
        }

        StringBuilder sb = new StringBuilder();

        boolean podeAtacar;
        switch (tipoAtaque) {
            case 1:
                podeAtacar = realizarAtaque(15);

                if (podeAtacar) {
                    dano = (this.inteligencia * 1.8) + (this.forca * 0.05);
                    sb.append(this.nome + " lança uma Bola de Fogo!");
                }
                else {
                    dano = ataquePadrao;
                    sb.append("Sem mana suficiente. Utilizando ataque padrão.");
                }
                break;
            case 2:
                podeAtacar = realizarAtaque(12);

                if (podeAtacar) {
                    dano = this.inteligencia * 1.5;
                    sb.append(this.nome + " dispara um Raio Arcano!");
                }
                else {
                    dano = ataquePadrao;
                    sb.append("Sem mana suficiente. Utilizando ataque padrão.");
                }

                break;
            case 3:
                podeAtacar = realizarAtaque(80);

                if (podeAtacar) {
                    dano = this.inteligencia * 2.8;
                    sb.append(this.nome + " dispara Explosão Primordial!");
                }
                else {
                    dano = ataquePadrao;
                    sb.append("Sem mana suficiente. Utilizando ataque padrão.");
                }

                break;
            default:
                sb.append("Opção de ataque inválida! Usando ataque padrão.");
                dano = this.inteligencia * 1.5;
                break;
        }

        if (critico && tipoAtaque != 3) {
            sb.append(" FOI UM ACERTO CRÍTICO!!!");
            dano *= 2;
        }

        sb.append("\n");
        System.out.print(sb);

        mana += 10;

        return dano;
    }

    @Override
    public int getModificador() {
        return mana;
    }

    @Override
    public void exibirAtaques() {
        System.out.println("Escolha o ataque:");
        System.out.println("1 - Bola de Fogo (15 de mana)");
        System.out.println("2 - Raio Arcano (12 de mana)");
        System.out.println("3 - Explosão Primordial (80 de mana)");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-------------- Mago Criado --------------\n");
        sb.append(String.format("Nome: %s\n", nome));
        sb.append("Classe: Mago\n");
        sb.append(String.format("Pontos de vida: %.0f\n", pontosDeVida));
        sb.append(String.format("Força: %d\n", forca));
        sb.append(String.format("Inteligência: %d\n",inteligencia));
        sb.append(String.format("Mana: %d\n", mana));

        return sb.toString();
    }
}