package entidades;

import java.util.ArrayList;
import java.time.LocalDate;

public final class Paciente extends Pessoa{

    public Paciente(String nome,
                    String cpf,
                    LocalDate dataNascimento,
                    ArrayList<Consulta> historicoMedico){

        super(nome, cpf, dataNascimento, historicoMedico);
    }

}
