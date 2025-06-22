package arena.entity;

public class Guerreiro extends Personagem {

    public Guerreiro(String nome, int pontosDeVida, int forca, int inteligencia) {
        super(nome, pontosDeVida, forca, inteligencia);
    }

    //polimorfismo
    //cumpre o contrato da classe pai
    @Override
    public double atacar(int tipoAtaque, int valorDado) {
        boolean critico = valorDado >= 18;
        boolean falha = valorDado <= 4;
        if (falha) {
            System.out.println(this.nome + " falhou em seu ataque.");
            return 0;
        }

        StringBuilder sb = new StringBuilder();

        double dano = 0;
        switch (tipoAtaque) {
            case 1:
                sb.append(this.nome + " usa Ataque Brutal!");
                dano = (this.forca * 2.5) + (this.pontosDeVida * 0.1);
                break;
            case 2:
                sb.append(this.nome + " usa Golpe Rápido!");
                dano = this.forca * 1.8;
                break;
            default:
                sb.append("Opção de ataque inválida! Usando ataque padrão.");
                dano = this.forca * 1.5;
                break;
        }

        if (critico) {
            System.out.print(" FOI UM ATAQUE CRITICO!!!");
            dano *= 1.8;
        }

        sb.append("\n");
        System.out.println(sb);

        return dano;
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

        return sb.toString();
    }
}