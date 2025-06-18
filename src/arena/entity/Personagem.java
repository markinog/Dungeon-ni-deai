package arena.entity;

public abstract class Personagem {

    protected String nome;

    //modificadores de acesso
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

    public abstract double atacar(int tipoAtaque);
}