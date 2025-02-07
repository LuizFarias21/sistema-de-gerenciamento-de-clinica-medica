package controladores;

import entidades.Consulta;
import entidades.Paciente;
import excecoes.CpfInvalidoException;
import interfaces.PacienteInterface;
import servicos.PacienteServico;

import java.time.LocalDate;
import java.util.ArrayList;

public class PacienteControlador {

    private PacienteServico pacienteServico;
    private PacienteInterface pacienteInterface;

    public PacienteControlador(PacienteServico pacienteServico) {
        this.pacienteServico = pacienteServico;
    }

    public void setPacienteInterface(PacienteInterface pacienteInterface) {
        this.pacienteInterface = pacienteInterface;
    }

    public void cadastrarPaciente(String nome, String cpf, LocalDate dataNascimento) {
        ArrayList<Consulta> historicoMedico = new ArrayList<Consulta>();
        Paciente paciente = new Paciente(nome, cpf, dataNascimento, historicoMedico);

        try {

            if (validarCpf(paciente.getCpf())) {
                throw new CpfInvalidoException("Cadastro bloqueado! Você precisa digitar um CPF válido!");
            }

            pacienteServico.cadastrar(paciente);
        } catch (CpfInvalidoException e ) {
            pacienteInterface.exibirMensagemErro(e.getMessage());
        }
    }

    public Paciente buscarPaciente(String cpf) {

        try {

            if (validarCpf(cpf)) {
                throw new CpfInvalidoException("Você precisa digitar um CPF válido!");
            }

            Paciente paciente = pacienteServico.buscar(cpf);

            if (paciente != null) {
                pacienteInterface.exibirMensagemInfo("Paciente encontrado: " + paciente.getNome());
            }

            return paciente;
        } catch (CpfInvalidoException e ) {
            pacienteInterface.exibirMensagemErro(e.getMessage());
        }
        return null;
    }

    public String listarPaciente() {
        ArrayList<Paciente> listaPacientes = pacienteServico.listar();
        String mensagem = "";
        for (Paciente paciente : listaPacientes) {
            mensagem +=  paciente.getCpf() + " - " + paciente.getNome() + "\n";
        }
        return mensagem;
    }

    public boolean validarCpf(String cpf) {
        if (cpf.trim().isEmpty()) {
            return true;
        }
        return false;
    }
}
