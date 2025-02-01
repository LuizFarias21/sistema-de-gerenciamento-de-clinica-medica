package entidades;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Consulta {

    private static int contadorID = 1;

    private String ID;
    private LocalDate dataConsulta;
    private LocalTime horarioInicialConsulta;
    private LocalTime duracaoConsulta;
    private LocalTime horarioFinalConsulta;
    private int status;
    private Paciente pacienteAssociado;
    private Medico medicoResponsavel;
    private ArrayList<Exame> examesPrescritos;
    private ArrayList<Medicamento> medicamentosPrescritos;
    private double valorConsulta;


    public Consulta(LocalDate dataConsulta, LocalTime horarioInicialConsulta, LocalTime duracaoConsulta, int status, Paciente pacienteAssociado, Medico medicoResponsavel, ArrayList<Exame> examesPrescritos, ArrayList<Medicamento> medicamentosPrescritos, double valorConsulta) {
        this.ID = String.valueOf(contadorID++);
        this.dataConsulta = dataConsulta;
        this.horarioInicialConsulta = horarioInicialConsulta;
        this.duracaoConsulta = duracaoConsulta;
        this.horarioFinalConsulta = horarioInicialConsulta.plusHours(duracaoConsulta.getHour()).plusMinutes(duracaoConsulta.getMinute());
        this.status = status;
        this.pacienteAssociado = pacienteAssociado;
        this.medicoResponsavel = medicoResponsavel;
        this.examesPrescritos = examesPrescritos;
        this.medicamentosPrescritos = medicamentosPrescritos;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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

    public double getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(double valorConsulta) {
        this.valorConsulta = valorConsulta;
    }
}
