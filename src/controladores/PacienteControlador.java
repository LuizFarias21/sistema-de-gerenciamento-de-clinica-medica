package controladores;

import entidades.Consulta;
import entidades.Paciente;
import excecoes.DadoInvalidoException;
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
                throw new DadoInvalidoException("Cadastro bloqueado! Você precisa digitar um CPF válido!");
            }

            pacienteServico.cadastrar(paciente);
        } catch (DadoInvalidoException e ) {
            pacienteInterface.exibirMensagemErro(e.getMessage());
        }
    }

    public Paciente buscarPaciente(String cpf) {

        try {

            if (validarCpf(cpf)) {
                throw new DadoInvalidoException("Você precisa digitar um CPF válido!");
            }

            Paciente paciente = pacienteServico.buscar(cpf);

            if (paciente != null) {
                pacienteInterface.exibirMensagemInfo("Paciente encontrado: " + paciente.getNome());
            }

            return paciente;
        } catch (DadoInvalidoException e ) {
            pacienteInterface.exibirMensagemErro(e.getMessage());
        }
        return null;
    }

    public void listarPaciente() {

        String mensagem = "";

        try {

            ArrayList<Paciente> listaPacientes = pacienteServico.listar();

            for (Paciente paciente : listaPacientes) {
                mensagem +=  paciente.getCpf() + " - " + paciente.getNome() + "\n";
            }

            pacienteInterface.exibirMensagemInfo(mensagem);

        } catch (DadoInvalidoException e ) {
            pacienteInterface.exibirMensagemErro(e.getMessage());
        }

    }

    public void atualizarPaciente(String cpf, String novoNome, String novoCpf, LocalDate novaDataNascimento) {

        try {
            //Paciente novoPaciente = new Paciente(novoNome, novoCpf, novaDataNascimento, new ArrayList<Consulta>()); // Precisa atualizar o histórico médico também!
            pacienteServico.atualizar(cpf, novoNome, novoCpf, novaDataNascimento);
            pacienteInterface.exibirMensagemInfo("Paciente atualizado com sucesso!");
        } catch (DadoInvalidoException e) {
            pacienteInterface.exibirMensagemErro(e.getMessage());
        }
    }

    public void excluirPaciente(String cpf) {

        try {
            if (validarCpf(cpf)) {
                throw new DadoInvalidoException("Você precisa digitar um CPF válido!");
            }
            pacienteServico.excluir(cpf);
            pacienteInterface.exibirMensagemInfo("Registro do paciente com o " + cpf + " foi excluído com sucesso!");
        } catch (DadoInvalidoException e) {
            pacienteInterface.exibirMensagemErro(e.getMessage());
        }
    }

    public boolean validarCpf(String cpf) {

        boolean cpfVazio = cpf.trim().isEmpty();

        if (cpfVazio) {
            return true;
        }

        return false;
    }
}
