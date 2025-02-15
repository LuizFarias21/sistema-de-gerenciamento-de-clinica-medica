package servicos;

import entidades.Consulta;
import entidades.Paciente;
import excecoes.DadoInvalidoException;
import repositorios.PacienteRepositorio;

import java.time.LocalDate;
import java.util.ArrayList;

public class PacienteServico extends PessoaServico<Paciente> {

    private PacienteRepositorio pacienteRepositorio;

    public PacienteServico(PacienteRepositorio pacienteRepositorio) {
        super(pacienteRepositorio);
        this.pacienteRepositorio = pacienteRepositorio;
    }

    public static void registrarHistorico(Consulta consulta) {
        consulta.getPacienteAssociado().getHistoricoMedico().add(consulta);
    }

    /*
    @Override
    public void atualizar(Paciente paciente, Paciente novaEntidade) throws DadoInvalidoException {
        super.atualizar(paciente, novaEntidade);
        //paciente.setHistoricoMedico(novaEntidade.getHistoricoMedico());
    }
    */
}
