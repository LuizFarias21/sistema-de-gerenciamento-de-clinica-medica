package entidades;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Consulta {

    private String ID;
    private LocalDate dataConsulta;
    private LocalTime duracaoConsulta;
    private String status;
    private Paciente pacienteAssociado;
    private Medico medicoResponsavel;
    private ArrayList<Exame> examesPrescritos;
    private ArrayList<Medicamento> medicamentosPrescritos;
    private double valorConsulta;


    public Consulta(String ID, LocalDate dataConsulta, LocalTime duracaoConsulta, String status, Paciente pacienteAssociado, Medico medicoResponsavel, ArrayList<Exame> examesPrescritos, ArrayList<Medicamento> medicamentosPrescritos, double valorConsulta) {
        this.ID = ID;
        this.dataConsulta = dataConsulta;
        this.duracaoConsulta = duracaoConsulta;
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
}
