package entidades;

import java.time.LocalDate;

public class Exame {

    private enum Tipo {
        SANGUE,
        RAIO_X,
        ULTRASSOM
    }

    private static int contadorID = 1;
    private String id;
    private Tipo tipo;
    private LocalDate dataPrescricao;
    private LocalDate dataRealizacao;
    private String resultadoExame;
    private double custoExame;

    Exame(Tipo tipo, LocalDate dataPrescricao, LocalDate dataRealizacao, String resultadoExame, double custoExame) {
        this.id = String.valueOf(contadorID++);
        this.tipo = tipo;
        this.dataPrescricao = dataPrescricao;
        this.dataRealizacao = dataRealizacao;
        this.resultadoExame = resultadoExame;
        this.custoExame = custoExame;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
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
