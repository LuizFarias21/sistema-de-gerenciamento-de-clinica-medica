package servicos;

import entidades.Consulta;
import entidades.Paciente;
import excecoes.CpfInvalidoException;
import repositorios.PacienteRepositorio;

import java.util.ArrayList;

public class PacienteServico {

    private PacienteRepositorio pacienteRepositorio;

    public PacienteServico(PacienteRepositorio pacienteRepositorio) {
        this.pacienteRepositorio = pacienteRepositorio;
    }

    public void registrarHistorico (Consulta consulta) {
        consulta.getPacienteAssociado().getHistoricoMedico().add(consulta);
    }

    public void cadastrarPaciente(Paciente paciente) throws CpfInvalidoException {
        if (pacienteRepositorio.buscar(paciente.getCpf()) != null) {
            throw new CpfInvalidoException("Cadastro bloqueado! Pois já existe um paciente cadastrado com o CPF: " + paciente.getCpf());
        }
        pacienteRepositorio.salvar(paciente);
    }

    public Paciente buscarPaciente(String cpf) throws CpfInvalidoException {
        if (pacienteRepositorio.buscar(cpf) == null ) {
            throw new CpfInvalidoException("Não foi encontrado nenhum paciente com o CPF: " + cpf);
        }
        return pacienteRepositorio.buscar(cpf);
    }

    public ArrayList<Paciente> listarPaciente() {
        return pacienteRepositorio.listar();

    }

}
