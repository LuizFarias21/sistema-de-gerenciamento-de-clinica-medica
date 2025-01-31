package entidades;

import java.util.ArrayList;
import java.time.LocalDate;

public class Paciente extends Pessoa{

    //, ArrayList<Clinica> historicoMedico
    public Paciente(String nome, String cpf, LocalDate dataNascimento, ArrayList<Consulta> historicoMedico){
        super(nome, cpf, dataNascimento, historicoMedico);
    }
}
