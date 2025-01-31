package entidades;

import java.time.LocalDate;
import java.util.ArrayList;

public class Medico extends Pessoa{

    private String crm;
    private String especialidade;

    public Medico(String nome, String CPF, LocalDate dataNascimento, String crm, String especialidade, ArrayList<Consulta> historicoMedico) {
        super(nome, CPF, dataNascimento, historicoMedico);
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
