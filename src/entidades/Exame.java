package entidades;

import java.time.LocalDate;

public class Exame extends Atendimento{

//    private enum Tipo {
//        SANGUE,
//        RAIO_X,
//        ULTRASSOM
//    }

    private String tipo;
    private LocalDate dataPrescricao;
    private LocalDate dataRealizacao;
    private String resultado;


    public Exame(String tipo, LocalDate dataPrescricao, LocalDate dataRealizacao, String resultado, double custo) {
        super(custo);
        this.tipo = tipo;
        this.dataPrescricao = dataPrescricao;
        this.dataRealizacao = dataRealizacao;
        this.resultado = resultado;
    }

    public Exame(String tipo, double custo) {
        super(custo);
        this.tipo = tipo;
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

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
