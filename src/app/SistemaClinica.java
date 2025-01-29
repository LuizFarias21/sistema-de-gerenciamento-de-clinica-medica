package app;

import entidades.Medico;
import entidades.Paciente;
import servicos.ServicoMedico;
import servicos.ServicoPaciente;

import java.time.LocalDate;

public class SistemaClinica {
    public static void main(String[] args) {

        ServicoPaciente teste = new ServicoPaciente();
        teste.adicionar(new Paciente("Lúcio Pato Sem Rabo", "12345678900", LocalDate.of(1969, 7, 14)));
        teste.atualizarPaciente("12345678900", "Lúcio Pato Serabo", "12345678900", LocalDate.of(1969, 7, 14));
        System.out.println("Paciente mencionado: " + teste.buscar("12345678900").getNome());
        teste.remover("12345678900");
        System.out.println(teste.buscar("12345678900"));

        System.out.println("\n-------------------------------------\n");

        ServicoMedico teste2 = new ServicoMedico();
        teste2.adicionar(new Medico("Pedro Ferreira Dantas", "98765432100", LocalDate.of(1980, 2, 20), "1234", "Odontologia"));
        teste2.atualizarMedico("98765432100", "Pedro Ferreira Dantas", "98765432100", LocalDate.of(1980, 11, 20), "4321", "Odontologia");
        System.out.println("Médico mencionado: " + teste2.buscar("98765432100").getNome());
        teste2.remover("98765432100");
        System.out.println(teste.buscar("98765432100"));


    }
}
