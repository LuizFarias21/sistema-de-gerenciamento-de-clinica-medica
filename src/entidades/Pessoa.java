package entidades;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Pessoa {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private ArrayList<Consulta> historicoMedico;

    public Pessoa(String nome, String cpf, LocalDate dataNascimento, ArrayList<Consulta> historicoMedico) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.historicoMedico = historicoMedico;
    }

//    public void adicionarConsulta(Consulta consulta) {
//        historicoMedico.add(consulta);
//    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public ArrayList<Consulta> getHistoricoMedico() {
        return historicoMedico;
    }

    public void setHistoricoMedico(ArrayList<Consulta> historicoMedico) {
        this.historicoMedico = historicoMedico;
    }

}
