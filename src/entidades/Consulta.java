package entidades;

import java.time.LocalDate;
import java.time.LocalTime;

public class Consulta {

    public enum Status {
        AGENDADA,
        CANCELADA,
        REALIZADA
    }

    private LocalDate dataAgendada;
    private LocalTime horarioInicialConsulta;
    private LocalTime duracaoConsulta;
    private LocalTime horarioFinalConsulta;
    private Status status;
    private Paciente pacienteAssociado;
    private Medico medicoResponsavel;
    private Prescricao prescricao;
    private String especialidadeRequerida;
    private double custo;


    public Consulta(LocalDate dataAgendada, LocalTime horarioInicialConsulta, LocalTime duracaoConsulta, Status status, Paciente pacienteAssociado, Medico medicoResponsavel, Prescricao prescricao, String especialidadeRequerida, double custo) {
        this.dataAgendada = dataAgendada;
        this.horarioInicialConsulta = horarioInicialConsulta;
        this.duracaoConsulta = duracaoConsulta;
        this.horarioFinalConsulta = horarioInicialConsulta.plusHours(duracaoConsulta.getHour()).plusMinutes(duracaoConsulta.getMinute());
        this.status = status;
        this.pacienteAssociado = pacienteAssociado;
        this.medicoResponsavel = medicoResponsavel;
        this.prescricao = prescricao;
        this.especialidadeRequerida = especialidadeRequerida;
        this.custo = custo;
    }

//    public Consulta(LocalDate dataRealizacao, LocalTime horarioInicialConsulta, LocalTime duracaoConsulta, Status status, Paciente pacienteAssociado, Medico medicoResponsavel, double valor){
//        super(dataRealizacao, valor);
//        this.horarioInicialConsulta = horarioInicialConsulta;
//        this.duracaoConsulta = duracaoConsulta;
//        this.horarioFinalConsulta = horarioInicialConsulta.plusHours(duracaoConsulta.getHour()).plusMinutes(duracaoConsulta.getMinute());
//        this.status = status;
//        this.pacienteAssociado = pacienteAssociado;
//        this.medicoResponsavel = medicoResponsavel;
//    }


    public LocalDate getDataAgendada() {
        return dataAgendada;
    }

    public void setDataAgendada(LocalDate dataAgendada) {
        this.dataAgendada = dataAgendada;
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

    public String getEspecialidadeRequerida() {
        return especialidadeRequerida;
    }

    public void setEspecialidadeRequerida(String especialidadeRequerida) {
        this.especialidadeRequerida = especialidadeRequerida;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }
}
