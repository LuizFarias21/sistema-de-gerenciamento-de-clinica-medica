package controladores;

import entidades.Consulta;
import entidades.Medico;
import interfaces.MedicoInterface;
import servicos.MedicoServico;

import java.time.LocalDate;
import java.util.ArrayList;

public class MedicoControlador {
    private MedicoServico medicoServico;
    private MedicoInterface medicoInterface;

    public MedicoControlador(MedicoServico medicoServico) {
        this.medicoServico = medicoServico;
    }

    public void cadastrarMedico(String nome, String cpf, LocalDate dataNascimento, String crm, String especialidade) {
        ArrayList<Consulta> historicoMedico = new ArrayList<Consulta>();
        Medico medico = new Medico(nome, cpf, dataNascimento, crm, especialidade, historicoMedico);

        if (medico.getCpf() == null) {
            throw new IllegalArgumentException("CPF nulo!");
        }
        medicoServico.cadastrarMedico(medico);
    }
}
