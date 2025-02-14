package entidades;

public class Medicamento extends Tratamento {

    private String nome;

    public Medicamento(String id, String nome) {
        super(id);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
