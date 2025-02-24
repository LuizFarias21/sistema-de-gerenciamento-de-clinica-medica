package entidades;

public final class Medicamento extends Tratamento {

    private String nome;

    public Medicamento( String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
