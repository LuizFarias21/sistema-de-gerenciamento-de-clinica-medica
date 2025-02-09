package controladores;

import entidades.Consulta;
import entidades.Paciente;
import excecoes.DadoInvalidoException;
import servicos.PacienteServico;
import visoes.PacienteVisao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PacienteControlador extends PessoaControlador<Paciente> {

    private PacienteServico pacienteServico;
    private PacienteVisao pacienteInterface;

    public PacienteControlador(PacienteServico pacienteServico) {
        this.pacienteServico = pacienteServico;
    }

    public void setPacienteInterface(PacienteVisao pacienteInterface) {
        this.pacienteInterface = pacienteInterface;
    }

    public void cadastrarPaciente(String nome, String cpf, LocalDate dataNascimento) {
        ArrayList<Consulta> historicoMedico = new ArrayList<Consulta>();
        Paciente paciente = new Paciente(nome, cpf, dataNascimento, historicoMedico);

        try {

            if (validarCpf(cpf)) {
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

//    public void atualizarPaciente(String cpf, String novoNome, String novoCpf, LocalDate novaDataNascimento) {
//
//        try {
//            //Paciente novoPaciente = new Paciente(novoNome, novoCpf, novaDataNascimento, new ArrayList<Consulta>()); // Precisa atualizar o histórico médico também!
//            pacienteServico.atualizar(cpf, novoNome, novoCpf, novaDataNascimento);
//            pacienteInterface.exibirMensagemInfo("Paciente atualizado com sucesso!");
//        } catch (DadoInvalidoException e) {
//            pacienteInterface.exibirMensagemErro(e.getMessage());
//        }
//    }

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

        // Segue o formato XXX.XXX.XXX-XX?
        Pattern cpfPattern = Pattern.compile("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}");
        Matcher cpfMatcher = cpfPattern.matcher(cpf);

        if (!cpfMatcher.matches() || cpf.trim().isEmpty()) return true;
        return false;
    }
}