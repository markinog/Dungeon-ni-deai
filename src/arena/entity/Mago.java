package arena.entity;

public class Mago extends Personagem {

    public Mago(String nome, int pontosDeVida, int forca, int inteligencia) {
        super(nome, pontosDeVida, forca, inteligencia);
    }

    //polimorfismo
    //cumpre o contrato da classe pai
    @Override
    public double atacar(int tipoAtaque) {
        double dano = 0;
        switch (tipoAtaque) {
            case 1:
                System.out.println(this.nome + " lança uma Bola de Fogo!");
                dano = (this.inteligencia * 2.8) + (this.forca * 0.05);
                break;
            case 2:
                System.out.println(this.nome + " dispara um Raio Arcano!");
                dano = this.inteligencia * 2.2;
                break;
            default:
                System.out.println("Opção de ataque inválida! Usando ataque padrão.");
                dano = this.inteligencia * 1.5;
                break;
        }
        return dano;
    }
}