package app;

import entidades.*;
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

        Consulta consultaTeste = new Consulta("1", LocalDate.of(2024, 7, 14), LocalTime.now(), "teste", teste.buscar("123.456.789-00"), teste2.buscar("987.654.321-00 "), new ArrayList<Exame>(), new ArrayList<Medicamento>(), 9.99);
        System.out.println(consultaTeste.getID());

    }
}
