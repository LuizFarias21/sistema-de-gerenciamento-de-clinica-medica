package entidades;

import java.util.List;
import java.time.LocalDate;

public class Paciente extends Pessoa{

    //, List<Clinica> historicoMedico
    public Paciente(String nome, String cpf, LocalDate dataNascimento, List<Consulta> historicoMedico){
        super(nome, cpf, dataNascimento, historicoMedico);
    }

    
}
