package servicos;

import entidades.Consulta;
import entidades.Medico;
import excecoes.DadoInvalidoException;
import repositorios.MedicoRepositorio;

public class MedicoServico extends PessoaServico<Medico> {

    private MedicoRepositorio medicoRepositorio;

    public MedicoServico(MedicoRepositorio medicoRepositorio) {
        super(medicoRepositorio);
        this.medicoRepositorio = medicoRepositorio;
    }

    public static void registrarHistorico(Consulta consulta) {
        consulta.getMedicoResponsavel().getHistoricoMedico().add(consulta);
    }

    @Override
    public void atualizar(Medico medico, Medico novaEntidade) throws DadoInvalidoException {

    }
}