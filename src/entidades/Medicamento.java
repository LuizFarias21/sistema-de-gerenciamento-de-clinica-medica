package entidades;

public class Medicamento {

    private static int contadorId = 1;
    private String id;
    private String nomeMedicamento;

    public Medicamento(String nomeMedicamento) {
        this.nomeMedicamento = nomeMedicamento;
        this.id = String.valueOf(contadorId++);
    }



    public String getNomeMedicamento() {
        return nomeMedicamento;
    }

    public void setNomeMedicamento(String nomeMedicamento) {
        this.nomeMedicamento = nomeMedicamento;
    }
}
