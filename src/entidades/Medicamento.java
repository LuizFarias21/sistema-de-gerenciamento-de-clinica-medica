package entidades;

public class Medicamento {

    private static int contadorID = 1;
    private String ID;
    private String nomeMedicamento;

    public Medicamento(String nomeMedicamento) {
        this.nomeMedicamento = nomeMedicamento;
        this.ID = String.valueOf(contadorID++);
    }



    public String getNomeMedicamento() {
        return nomeMedicamento;
    }

    public void setNomeMedicamento(String nomeMedicamento) {
        this.nomeMedicamento = nomeMedicamento;
    }
}
