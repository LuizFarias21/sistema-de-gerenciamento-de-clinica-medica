package entidades;

import java.time.LocalDate;

public class Exame extends Atendimento {

//    private enum Tipo {
//        SANGUE,
//        RAIO_X,
//        ULTRASSOM
//    }

    private String nome;
    private LocalDate dataRealizacao;
    private String resultadoExame;


    public Exame(String nome, LocalDate dataPrescricao, LocalDate dataRealizacao, String resultadoExame, double custo) {
        super(dataPrescricao, custo);
        this.dataRealizacao = dataRealizacao;
        this.nome = nome;
        this.resultadoExame = resultadoExame;

    }

    public LocalDate getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(LocalDate dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }
}
