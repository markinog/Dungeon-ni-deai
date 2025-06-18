package arena.entity;

public class Guerreiro extends Personagem {

    public Guerreiro(String nome, int pontosDeVida, int forca, int inteligencia) {
        super(nome, pontosDeVida, forca, inteligencia);
    }

    //polimorfismo
    @Override
    public double atacar(int tipoAtaque) {
        double dano = 0;
        switch (tipoAtaque) {
            case 1:
                System.out.println(this.nome + " usa Ataque Brutal!");
                dano = (this.forca * 2.5) + (this.pontosDeVida * 0.1);
                break;
            case 2:
                System.out.println(this.nome + " usa Golpe Rápido!");
                dano = this.forca * 1.8; // Fórmula mais simples
                break;
            default:
                System.out.println("Opção de ataque inválida! Usando ataque padrão.");
                dano = this.forca * 1.5;
                break;
        }
        return dano;
    }
}