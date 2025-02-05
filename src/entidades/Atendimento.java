package entidades;

import java.text.DecimalFormat;
import java.time.LocalDate;

public abstract class Atendimento {

    //private DecimalFormat formatoID = new DecimalFormat("000");
    //private static int contadorID = 1;
    //private String id;
    private LocalDate dataRealizacao;
    private double custo;

    //public Atendimento(){}

    public Atendimento(LocalDate dataRealizacao, double custo) {
        //this.id = formatoID.format(contadorID++);
        this.dataRealizacao = dataRealizacao;
        this.custo = custo;
    }

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

    public LocalDate getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(LocalDate dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public double getCusto() {
        return custo;
    }
}