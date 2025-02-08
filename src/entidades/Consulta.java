package entidades;

import java.time.LocalDate;
import java.time.LocalTime;

public class Consulta extends Atendimento{

    public enum Status {
        AGENDADA,
        CANCELADA,
        REALIZADA
    }

    private LocalDate dataAgendada;
    private LocalTime horario;
    private LocalTime duracao;
    private Status status;
    private Paciente pacienteAssociado;
    private Medico medicoResponsavel;
    private Prescricao prescricao;
    private String especialidadeRequerida;


    public Consulta(LocalDate dataAgendada, LocalTime horario, LocalTime duracao, Status status, Paciente pacienteAssociado, Medico medicoResponsavel, Prescricao prescricao, String especialidadeRequerida, double custo) {
        super(custo);
        this.dataAgendada = dataAgendada;
        this.horario = horario;
        this.duracao = duracao;
        this.status = status;
        this.pacienteAssociado = pacienteAssociado;
        this.medicoResponsavel = medicoResponsavel;
        this.prescricao = prescricao;
        this.especialidadeRequerida = especialidadeRequerida;
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

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public LocalTime getDuracao() {
        return duracao;
    }

    public void setDuracao(LocalTime duracao) {
        this.duracao = duracao;
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
}
