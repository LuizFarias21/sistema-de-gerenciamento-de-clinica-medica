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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataPrescricao() {
        return dataPrescricao;
    }

    public void setDataPrescricao(LocalDate dataPrescricao) {
        this.dataPrescricao = dataPrescricao;
    }

    public LocalDate getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(LocalDate dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    public String getResultadoExame() {
        return resultadoExame;
    }

    public void setResultadoExame(String resultadoExame) {
        this.resultadoExame = resultadoExame;
    }

    public double getCustoExame() {
        return custoExame;
    }

    public void setCustoExame(double custoExame) {
        this.custoExame = custoExame;
    }
}
