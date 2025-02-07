package entidades;

import java.time.LocalDate;

public abstract class Atendimento {

    private LocalDate dataPrescricao;
    private double custo;

    //public Atendimento(){}

    public Atendimento(LocalDate dataRealizacao, double custo) {
        this.dataPrescricao = dataRealizacao;
        this.custo = custo;
    }

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }


    public LocalDate getDataPrescricao() {
        return dataPrescricao;
    }

    public void setDataPrescricao(LocalDate dataPrescricao) {
        this.dataPrescricao = dataPrescricao;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public double getCusto() {
        return custo;
    }
}