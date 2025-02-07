package entidades;

import java.time.LocalDate;

public class Exame {

//    private enum Tipo {
//        SANGUE,
//        RAIO_X,
//        ULTRASSOM
//    }

    private String nome;
    private LocalDate dataAgendada;
    private LocalDate dataRealizacao;
    private String resultadoExame;
    private double custo;


    public Exame(String nome, LocalDate dataPrescricao, LocalDate dataRealizacao, String resultadoExame, double custo) {
        this.nome = nome;
        this.dataAgendada = dataPrescricao;
        this.dataRealizacao = dataRealizacao;
        this.resultadoExame = resultadoExame;
        this.custo = custo;
    }

    public LocalDate getDataAgendada() {
        return dataAgendada;
    }

    public void setDataAgendada(LocalDate dataAgendada) {
        this.dataAgendada = dataAgendada;
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

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }
}
