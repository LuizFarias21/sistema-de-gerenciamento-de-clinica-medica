package servicos;

import entidades.Consulta;
import entidades.Medico;
import repositorios.MedicoRepositorio;

public class MedicoServico {
    private MedicoRepositorio medicoRepositorio;

    public MedicoServico(MedicoRepositorio medicoRepositorio) {
        this.medicoRepositorio = medicoRepositorio;
    }

    public void registrarHistorico (Consulta consulta) {
        consulta.getMedicoResponsavel().getHistoricoMedico().add(consulta);
    }

    public void cadastrarMedico(Medico medico) {
        if (medicoRepositorio.buscar(medico.getCpf()) != null ) {
            throw new IllegalArgumentException("Erro: CPF já cadastrado.");
        }
        medicoRepositorio.salvar(medico);
    }
}