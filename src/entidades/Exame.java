package entidades;

import java.time.LocalDate;

public class Exame extends Atendimento{

//    private enum Tipo {
//        SANGUE,
//        RAIO_X,
//        ULTRASSOM
//    }

    private String nome;
    private LocalDate dataAgendada;
    private LocalDate dataRealizacao;
    private String resultadoExame;


    public Exame(String nome, LocalDate dataPrescricao, LocalDate dataRealizacao, String resultadoExame, double custo) {
        super(custo);
        this.nome = nome;
        this.dataAgendada = dataPrescricao;
        this.dataRealizacao = dataRealizacao;
        this.resultadoExame = resultadoExame;
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
}
