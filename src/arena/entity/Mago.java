package arena.entity;

public class Mago extends Personagem {

    private int mana;

    public Mago(String nome, int pontosDeVida, int forca, int inteligencia, int mana) {
        super(nome, pontosDeVida, forca, inteligencia);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
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

        switch (tipoAtaque) {
            case 1:
                sb.append(this.nome + " lança uma Bola de Fogo!");
                dano = (this.inteligencia * 2.8) + (this.forca * 0.05);
                break;
            case 2:
                sb.append(this.nome + " dispara um Raio Arcano!");
                dano = this.inteligencia * 2.2;
                break;
            default:
                sb.append("Opção de ataque inválida! Usando ataque padrão.");
                dano = this.inteligencia * 1.5;
                break;
        }

        if (critico) {
            sb.append(" FOI UM ACERTO CRÍTICO!!!");
            dano *= 2;
        }

        sb.append("\n");
        System.out.print(sb);

        return dano;
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