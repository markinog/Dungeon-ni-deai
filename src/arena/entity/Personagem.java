package arena.entity;

public abstract class Personagem {

    protected String nome;

    //modificadores de acesso e atributos encapsulados
    protected double pontosDeVida;
    protected int forca;
    protected int inteligencia;

    public Personagem(String nome, int pontosDeVida, int forca, int inteligencia) {
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
        this.inteligencia = inteligencia;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPontosDeVida() {
        return pontosDeVida;
    }

    public void setPontosDeVida(double pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }

    public boolean estaVivo() {
        return this.pontosDeVida > 0;
    }

    public void receberDano(double dano) {
        this.pontosDeVida -= dano;
        if (this.pontosDeVida < 0) {
            this.pontosDeVida = 0;
        }
    }

    //estabelece um contrato com as classes que herdarem Personagem
    public abstract double atacar(int tipoAtaque, int valorDado);
    public abstract void exibirAtaques();
    public abstract int getModificador();
}