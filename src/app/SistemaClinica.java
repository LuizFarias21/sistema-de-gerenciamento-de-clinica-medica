package app;

import entidades.*;
import servicos.ServicoConsulta;
import servicos.ServicoMedico;
import servicos.ServicoPaciente;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class SistemaClinica {
    public static void main(String[] args) {


        ServicoPaciente teste = new ServicoPaciente();
        teste.adicionar(new Paciente("Lúcio Pato Sem Rabo", "123.456.789-00", LocalDate.of(1969, 7, 14), new ArrayList<Consulta>()));
        teste.atualizar("123.456.789-00", new Paciente("Lúcio Pato Serabo", "123.456.789-00", LocalDate.of(1969, 7, 14), new ArrayList<Consulta>()));
        System.out.println("Paciente mencionado: " + teste.buscar("123.456.789-00").getNome());
        //teste.remover("123.456.789-00");
        //System.out.println(teste.buscar("123.456.789-00"));

        System.out.println("\n-------------------------------------\n");

        ServicoMedico teste2 = new ServicoMedico();
        teste2.adicionar(new Medico("Pedro Ferreira Dantas", "987.654.321-00", LocalDate.of(1980, 2, 20), "1234", "Odontologia", new ArrayList<Consulta>()));
        teste2.atualizar("987.654.321-00", new Medico("Pedro Ferreira Dantas", "987.654.321-00", LocalDate.of(1980, 11, 20), "4321", "Odontologia", new ArrayList<Consulta>()));
        System.out.println("Médico mencionado: " + teste2.buscar("987.654.321-00").getNome());
        //teste2.remover("987.654.321-00");
        //System.out.println(teste.buscar("987.654.321-00"));

        System.out.println("\n-------------------------------------\n");


        ServicoConsulta servicoConsulta = new ServicoConsulta();


        Paciente pacienteAssociado = teste.buscar("123.456.789-00");
        Medico medicoAssociado = teste2.buscar("987.654.321-00");

        // Realizar consulta
        //LocalTime duracaoConsulta, Paciente pacienteAssociado, Medico medicoAssociado, double valorConsulta
        Consulta consulta1 = servicoConsulta.realizarConsulta(LocalTime.of(14, 30), pacienteAssociado, medicoAssociado, 100.00);
        pacienteAssociado.adicionarConsulta(consulta1);
        medicoAssociado.adicionarConsulta(consulta1);

        System.out.println(consulta1.toString());
        System.out.println(pacienteAssociado.getHistoricoMedico().contains(consulta1));
        System.out.println(medicoAssociado.getHistoricoMedico().contains(consulta1));

        // Cancelar consulta
        servicoConsulta.cancelarConsulta(consulta1);

        System.out.println(pacienteAssociado.getHistoricoMedico().contains(consulta1));
        System.out.println(medicoAssociado.getHistoricoMedico().contains(consulta1));

        // Agendar consulta2
        Consulta consulta2 = servicoConsulta.agendarConsulta(LocalDate.of(2024, 2, 1), LocalTime.of(14, 30), LocalTime.of(0, 30), pacienteAssociado, medicoAssociado, 300.00);
        pacienteAssociado.adicionarConsulta(consulta2);
        medicoAssociado.adicionarConsulta(consulta2);

        System.out.println(consulta2.toString());
        System.out.println(consulta2.getID());
        System.out.println(pacienteAssociado.getHistoricoMedico().contains(consulta2));
        System.out.println(medicoAssociado.getHistoricoMedico().contains(consulta2));

        System.out.println("\n---------------------------------------\n");

        // Agendar consulta3
        //Consulta consulta3 = servicoConsulta.agendarConsulta(LocalDate.of(2024, 2, 2), LocalTime.of(14, 30), LocalTime.of(0, 30), pacienteAssociado, medicoAssociado, 150.00);
        //pacienteAssociado.adicionarConsulta(consulta3);
        //medicoAssociado.adicionarConsulta(consulta3);

        //System.out.println();



    }
}
