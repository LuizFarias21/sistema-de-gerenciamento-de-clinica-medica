package entidades;

import servicos.ServicoConsulta;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Consulta {

    public enum Status {
        AGENDADA,
        CANCELADA,
        REALIZADA
    }

    private static int contadorID = 1;
    private String ID;
    private LocalDate dataConsulta;
    private LocalTime horarioInicialConsulta;
    private LocalTime duracaoConsulta;
    private LocalTime horarioFinalConsulta;
    private Status status;
    private Paciente pacienteAssociado;
    private Medico medicoResponsavel;
    private Prescricao prescricao;
    private double valorConsulta;


    public Consulta(LocalDate dataConsulta, LocalTime horarioInicialConsulta, LocalTime duracaoConsulta, Status status, Paciente pacienteAssociado, Medico medicoResponsavel, Prescricao prescricao, double valorConsulta) {
        this.ID = String.valueOf(contadorID++);
        this.dataConsulta = dataConsulta;
        this.horarioInicialConsulta = horarioInicialConsulta;
        this.duracaoConsulta = duracaoConsulta;
        this.horarioFinalConsulta = horarioInicialConsulta.plusHours(duracaoConsulta.getHour()).plusMinutes(duracaoConsulta.getMinute());
        this.status = status;
        this.pacienteAssociado = pacienteAssociado;
        this.medicoResponsavel = medicoResponsavel;
        this.prescricao = prescricao;
        this.valorConsulta = valorConsulta;
    }

    public Consulta(LocalDate dataConsulta, LocalTime horarioInicialConsulta, LocalTime duracaoConsulta, Status status, Paciente pacienteAssociado, Medico medicoResponsavel, double valorConsulta){
        this.ID = String.valueOf(contadorID++);
        this.dataConsulta = dataConsulta;
        this.horarioInicialConsulta = horarioInicialConsulta;
        this.duracaoConsulta = duracaoConsulta;
        this.horarioFinalConsulta = horarioInicialConsulta.plusHours(duracaoConsulta.getHour()).plusMinutes(duracaoConsulta.getMinute());
        this.status = status;
        this.pacienteAssociado = pacienteAssociado;
        this.medicoResponsavel = medicoResponsavel;
        this.valorConsulta = valorConsulta;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public LocalTime getHorarioInicialConsulta() {
        return horarioInicialConsulta;
    }

    public void setHorarioInicialConsulta(LocalTime horarioInicialConsulta) {
        this.horarioInicialConsulta = horarioInicialConsulta;
    }

    public LocalTime getDuracaoConsulta() {
        return duracaoConsulta;
    }

    public void setDuracaoConsulta(LocalTime duracaoConsulta) {
        this.duracaoConsulta = duracaoConsulta;
    }

    public LocalTime getHorarioFinalConsulta() {
        return horarioFinalConsulta;
    }

    public void setHorarioFinalConsulta(LocalTime horarioFinalConsulta) {
        this.horarioFinalConsulta = horarioFinalConsulta;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Paciente getPacienteAssociado() {
        return pacienteAssociado;
    }

    public void setPacienteAssociado(Paciente pacienteAssociado) {
        this.pacienteAssociado = pacienteAssociado;
    }

    public Medico getMedicoResponsavel() {
        return medicoResponsavel;
    }

    public void setMedicoResponsavel(Medico medicoResponsavel) {
        this.medicoResponsavel = medicoResponsavel;
    }

    public Prescricao getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(Prescricao prescricao) {
        this.prescricao = prescricao;
    }

    public double getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(double valorConsulta) {
        this.valorConsulta = valorConsulta;
    }
}
