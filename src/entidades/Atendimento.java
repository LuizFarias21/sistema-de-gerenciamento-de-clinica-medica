package entidades;

// ⚠️ Não é certeza que essa classe será utilizada no trabalho final!
public abstract class Atendimento {

    private double custo;

    public Atendimento(double custo) {
        this.custo = custo;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }
}
