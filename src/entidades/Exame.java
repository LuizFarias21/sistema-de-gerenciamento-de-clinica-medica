package entidades;

import java.time.LocalDate;

public class Exame extends Atendimento {

//    private enum Tipo {
//        SANGUE,
//        RAIO_X,
//        ULTRASSOM
//    }

    // LocalDate dataRealizacao;
    private String nome;
    private LocalDate dataPrescricao;
    private String resultadoExame;
    //private double custoExame;

    public Exame(String nome, LocalDate dataPrescricao, LocalDate dataRealizacao, String resultadoExame, double custo) {
        super(dataRealizacao, custo);

        //this.dataRealizacao = dataRealizacao;
        this.nome = nome;
        this.dataPrescricao = dataPrescricao;
        this.resultadoExame = resultadoExame;

    }

//    public LocalDate getDataRealizacao() {
//        return dataRealizacao;
//    }
//
//    public void setDataRealizacao(LocalDate dataRealizacao) {
//        this.dataRealizacao = dataRealizacao;
//    }

    public String getResultadoExame() {
        return resultadoExame;
    }

    public void setResultadoExame(String resultadoExame) {
        this.resultadoExame = resultadoExame;
    }
}
