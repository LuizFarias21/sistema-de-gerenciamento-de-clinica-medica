package aplicacao;

import entidades.Consulta;
import entidades.Medicamento;
import entidades.Medico;
import entidades.Paciente;
import repositorios.*;
import servicos.ConsultaServico;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Aplicacao0 {
    public static void main(String[] args) {
        PacienteRepositorio pacienteRepositorio = new PacienteRepositorio();
        MedicoRepositorio medicoRepositorio = new MedicoRepositorio();
        ConsultaRepositorio consultaRepositorio = new ConsultaRepositorio();
        ConsultaServico consultaServico = new ConsultaServico();
        ExameRepositorio exameRepositorio = new ExameRepositorio();
        MedicamentoRepositorio medicamentoRepositorio = new MedicamentoRepositorio();

        Paciente paciente1 = new Paciente("Luiz Claudio", "123.456.789-00", LocalDate.of(1969, 7, 14), new ArrayList<Consulta>());
        pacienteRepositorio.salvar(paciente1);

        Medico medico1 = new Medico("Pedro", "987.654.321-00", LocalDate.of(1980, 2, 20), "1234", "Odontologia", new ArrayList<Consulta>());
        medicoRepositorio.salvar(medico1);

        consultaServico.agendarConsulta(LocalDate.of(2024, 2, 1), LocalTime.of(12, 0), LocalTime.of(0, 30), pacienteRepositorio.buscar("123.456.789-00"), medicoRepositorio.buscar("987.654.321-00"), "Odontologia", consultaRepositorio, 300.00);

        System.out.println("OK!");


    }
}
