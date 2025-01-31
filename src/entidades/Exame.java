package entidades;

import java.time.LocalDate;

public class Exame {

    private String ID;
    private String tipo;
    private LocalDate dataPrescricao;
    private LocalDate dataRealizacao;
    private String resultadoExame;
    private double custoExame;

    Exame(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
