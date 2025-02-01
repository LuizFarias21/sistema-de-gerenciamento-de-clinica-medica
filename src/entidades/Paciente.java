package entidades;

import java.util.ArrayList;
import java.time.LocalDate;

public class Paciente extends Pessoa{

    public Paciente(String nome,
                    String cpf,
                    LocalDate dataNascimento,
                    ArrayList<Consulta> historicoConsultas,
                    ArrayList<Exame> historicoExames){

        super(nome, cpf, dataNascimento, historicoConsultas, historicoExames);
    }


}
